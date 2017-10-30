package com.sofast.application.filter;

import com.google.common.base.Strings;
import com.sofast.application.entity.UserContextHolder;
import com.sofast.application.model.User;
import com.sofast.application.service.UserService;
import com.sofast.application.util.DateHelper;
import com.sofast.application.util.UUIDHelper;
import com.sofast.application.util.UserAccessUtil;
import com.sofast.application.util.XssHelper;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class LoginUserTokenFilter extends BaseFilter implements Filter {

    @Autowired
    private UserService userService;

    private List<String> cleanPathList = Collections.synchronizedList(new ArrayList<String>());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, filterConfig.getServletContext());
        initFilterParam(filterConfig);
        String excludeFiles = filterConfig.getInitParameter("cleanCookiePath");
        if (!Strings.isNullOrEmpty(excludeFiles)) {
            String[] files = excludeFiles.split(",");
            Collections.addAll(this.cleanPathList, files);
        }
    }

    private boolean isNeedCleanCookie(HttpServletRequest request){
        String resourceUrl = request.getRequestURI();
        for (String exPath : cleanPathList) {
            if (resourceUrl.contains(exPath)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (isExcludeRequst(request)) {
            if(isNeedCleanCookie(request)){
                UserAccessUtil.getInstance().clearSSOCookie(response);
            }
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        if(validate(request, response)) {
            try {
                filterChain.doFilter(servletRequest, servletResponse);
            } finally {
                UserContextHolder.clearUser();
            }
        } else {
            redirectLoginPage(request,response);
        }
    }

    /**
     * 检查cookie
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    private boolean validate(HttpServletRequest request, HttpServletResponse response) {
        if(!UserAccessUtil.getInstance().checkAuthCode(request)){
            return false;
        }
        String authCode = UserAccessUtil.getInstance().getAuthCode(request);
        User user = userService.getUserByAuthCode(authCode);
        if (null == user || null ==  user.getAuthCodeExpire() ) {
            log.error("无效的auth code：" + authCode);
            return false;
        }
        if(!XssHelper.xssEncode(user.getUserName()).equalsIgnoreCase(UserAccessUtil.getInstance().getUserLoginName(request))){
            log.error("错误的auth code：" + authCode);
            log.error("错误的user name：" + user.getUserName());
            return false;
        }
        DateTime authTokenExpireTime = new DateTime(user.getAuthCodeExpire());
        if(authTokenExpireTime.isBeforeNow()){
            log.error("已过期的auth code：" + authCode);
            return false;
        }
        if(authTokenExpireTime.minusSeconds(userService.getAuthRefresh()).isBeforeNow()){
            refreshAccessToken(response, user);
        }
        UserContextHolder.setUser(user);
        return true;
    }

    /**
     * refresh token
     * @param response
     * @return
     * @throws
     */
    private void refreshAccessToken(HttpServletResponse response, User student) {
        String authCode = UUIDHelper.getUUID();
        student.setAuthCode(authCode);
        student.setAuthCodeExpire(DateHelper.NowAddSeconds(userService.getAuthExpire()));
        userService.save(student);
        UserAccessUtil.getInstance().setSSOCookie(response,authCode, student.getUserName(), userService.getAuthExpire());
        UserAccessUtil.getInstance().setUserNameCookie(response, student.getUserName(), userService.getAuthExpire());
    }

    @Override
    public void destroy() {
        clearCollection();
    }
}
