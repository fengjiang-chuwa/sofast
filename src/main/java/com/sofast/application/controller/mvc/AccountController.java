package com.sofast.application.controller.mvc;

import com.sofast.application.service.UserService;
import com.sofast.application.util.UserAccessUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
public class AccountController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/user/login")
    public String login(HttpServletResponse response) {
        UserAccessUtil.getInstance().clearSSOCookie(response);
        return "login";
    }

    @GetMapping(path = "/user/logout")
    public String logout(HttpServletResponse response) {
        UserAccessUtil.getInstance().clearSSOCookie(response);
        return "redirect:/user/login";
    }

//    @GetMapping(path = "/error")
//    public String error(HttpServletResponse response) {
////        UserAccessUtil.getInstance().clearSSOCookie(response);
//        return "login";
//    }
}
