package com.sofast.application;

import com.sofast.application.filter.LoginUserTokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.servlet.Filter;

@SpringBootApplication
@EnableJpaRepositories("com.sofast.application.dao")
public class SpringBootWebApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootWebApplication.class);
	}

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(someFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("resourcePath", "/css/,/js/,/image/,/register/," +
                "/user/resetPassword,/error,/fonts,/student/linkId,/studentInput/data/linkId,/studentInfo,/fileUpload");
        registration.addInitParameter("cleanCookiePath", "/register,/user");
        registration.addInitParameter("excludeFile", "png,gif,jpg,bmp,js,css,jsp");
        registration.addInitParameter("excludePath", "/register,/user/login,/user/logout,/user/checkuser,/user/resetPassword," +
                "/user/userInfo,/user/error,/user/404");
        registration.setName("loginUserTokenFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public Filter someFilter() {
        return new LoginUserTokenFilter();
    }

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApplication.class, args);
	}

}