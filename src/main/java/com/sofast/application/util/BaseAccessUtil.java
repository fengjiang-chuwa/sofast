package com.sofast.application.util;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.sofast.application.util.CookieUtil.addCookie;
import static com.sofast.application.util.CookieUtil.getCookieValueByName;


/*
 *
 * @author fjiang
 * @description 
 * @date 7/20/16
 */
@Slf4j
public abstract class BaseAccessUtil {

    protected abstract String getAuthCode();

    protected abstract String getNameCookie();

    /**
     * Gets auth code.
     *
     * @param request the request
     * @return the auth code
     */
    public String getAuthCode(HttpServletRequest request) {
        String authCode = getCookieValueByName(request, getAuthCode());
        if (authCode == null) {
            return "";
        } else {
            if (authCode.length() < 36) {
                return authCode;
            } else {
                return authCode.substring(0, 36);
            }
        }
    }

    /**
     * Clear sso cookie.
     *
     * @param response the response
     */
    public void clearSSOCookie(HttpServletResponse response) {
        addCookie(response, getNameCookie(), null, 0);
        addCookie(response, getAuthCode(), null, 0);
    }

    /**
     * Set sso cookie.
     *
     * @param response  the response
     * @param authCode  the auth code
     * @param userName  the user name
     * @param expiredIn the expired in
     */
    public void setSSOCookie(HttpServletResponse response, String authCode, String userName, int expiredIn) {
        addCookie(response, getAuthCode(), XssHelper.xssEncode(authCode + userName), expiredIn);
    }

    /**
     * Set sso cookie.
     *
     * @param response  the response
     * @param userName  the user name
     * @param expiredIn the expired in
     */
    public void setUserNameCookie(HttpServletResponse response, String userName, int expiredIn) {
        addCookie(response, getNameCookie(), XssHelper.xssEncode(userName), expiredIn);
    }

    /**
     * Check auth code boolean.
     *
     * @param request the request
     * @return the boolean
     */
    public boolean checkAuthCode(HttpServletRequest request) {
        String authCode = getCookieValueByName(request, getAuthCode());
        return !(Strings.isNullOrEmpty(authCode) || authCode.length() < 37);
    }

    /**
     * Gets user login name.
     *
     * @param request the request
     * @return the user login name
     */
    public String getUserLoginName(HttpServletRequest request) {
        String authCode = getCookieValueByName(request, getAuthCode());
        if (authCode == null || authCode.length() < 37) {
            return "";
        }
        return authCode.substring(36);
    }

}
