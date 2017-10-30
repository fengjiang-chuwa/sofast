package com.sofast.application.filter;

import com.google.common.base.Strings;

import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 *
 * @author fjiang
 * @description 
 * @date 9/2/16
 */
public abstract class BaseFilter {
    private static final String LOGIN_PAGE_URL = "/mvc/user/login";
    private static final String TRAINING_LOGIN_PAGE_URL = "/mvc/training/login";
    /**
     * The Exclude path list.
     */
    protected List<String> excludePathList = Collections.synchronizedList(new ArrayList<String>());
    /**
     * The Exclude file list.
     */
    protected List<String> excludeFileList = Collections.synchronizedList(new ArrayList<String>());
    /**
     * The Resource path list.
     */
    protected List<String> resourcePathList = Collections.synchronizedList(new ArrayList<String>());

    /**
     * Gets request url.
     *
     * @param request the request
     * @return the request url
     */
    protected static String getRequestURL(HttpServletRequest request) {
        StringBuilder url = new StringBuilder(request.getRequestURL());
        String servletPath = request.getServletPath();
        int i = url.indexOf(servletPath);
        String sub = url.substring(i + servletPath.length());
        return sub;
    }

    /**
     * Gets file type.
     *
     * @param request the request
     * @return the file type
     */
    protected static String getFileType(HttpServletRequest request) {
        StringBuilder url = new StringBuilder(request.getRequestURL());
        String fileType = "";
        int i = url.lastIndexOf(".");
        if (i != -1) {
            fileType = url.substring(i + 1).toUpperCase();
        }
        return fileType;
    }

    /**
     * Is exclude requst boolean.
     *
     * @param request the request
     * @return the boolean
     */
    protected boolean isExcludeRequst(HttpServletRequest request) {
        String resourceUrl = request.getRequestURI();
        for (String exPath : resourcePathList) {
            if (resourceUrl.contains(exPath)) {
                return true;
            }
        }
        String requestUrl = getRequestURL(request);
        for (String exPath : excludePathList) {
            if (requestUrl.equals(exPath)) {
                return true;
            }
        }
        String fileType = getFileType(request);
        for (String exFileName : excludeFileList) {
            if (exFileName.equalsIgnoreCase(fileType)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 跳转到登陆页面
     *
     * @param request  request
     * @param response response
     * @throws IOException the io exception
     */
    protected void redirectLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accept = request.getHeader("Accept");
        if (Strings.isNullOrEmpty(accept) || !accept.contains("application/json")) {
            response.setStatus(302);
            response.sendRedirect(request.getContextPath() + LOGIN_PAGE_URL);
        } else {
            response.setStatus(401);
        }
    }

    /**
     * 跳转到登陆页面
     *
     * @param request  request
     * @param response response
     * @throws IOException the io exception
     */
    protected void redirectTrainingLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accept = request.getHeader("Accept");
        if (Strings.isNullOrEmpty(accept) || !accept.contains("application/json")) {
            response.setStatus(302);
            response.sendRedirect(request.getContextPath() + TRAINING_LOGIN_PAGE_URL);
        } else {
            response.setStatus(401);
        }
    }


    /**
     * Init filter param.
     */
    protected void initFilterParam(FilterConfig filterConfig) {
        String excludeFiles = filterConfig.getInitParameter("excludeFile");
        if (!Strings.isNullOrEmpty(excludeFiles)) {
            String[] files = excludeFiles.split(",");
            Collections.addAll(this.excludeFileList, files);
        }
        String excludePath = filterConfig.getInitParameter("excludePath");
        if (!Strings.isNullOrEmpty(excludePath)) {
            String[] files = excludePath.split(",");
            Collections.addAll(this.excludePathList, files);
        }
        String resources = filterConfig.getInitParameter("resourcePath");
        if (!Strings.isNullOrEmpty(resources)) {
            String[] pages = resources.split(",");
            Collections.addAll(this.resourcePathList, pages);
        }
    }

    /**
     * Clear collection.
     */
    protected void clearCollection() {
        this.excludeFileList.clear();
        this.excludePathList.clear();
        this.resourcePathList.clear();
    }
}
