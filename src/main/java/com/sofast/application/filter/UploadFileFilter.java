package com.sofast.application.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 *
 * @author fjiang
 * @description 
 * @date 8/26/16
 */
@Slf4j
public class UploadFileFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (MaxUploadSizeExceededException e) {
            handle(request, response, e);
        } catch (ServletException e) {
            if (e.getRootCause() instanceof MaxUploadSizeExceededException) {
                handle(request, response, (MaxUploadSizeExceededException) e.getRootCause());
            } else {
                throw e;
            }
        } catch (IOException e) {
            throw e;
        }
    }

    private void handle(HttpServletRequest request,
                        HttpServletResponse response, MaxUploadSizeExceededException e) {

        response.setStatus(400);
    }

    @Override
    public void destroy() {

    }
}
