package com.sofast.application.controller.rest;

import com.sofast.application.entity.JsonResponse;
import com.sofast.application.exception.MsgException;
import com.sofast.application.model.User;
import com.sofast.application.service.UserService;
import com.sofast.application.util.DateHelper;
import com.sofast.application.util.SecurityHelper;
import com.sofast.application.util.UUIDHelper;
import com.sofast.application.util.UserAccessUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class AccountRestController {

    private static final String NOT_FOUND_CODE = "NotFound.user.Error";
    private static final String BAD_REQUEST_CODE = "BadRequest.user.ErrorValidation";
    private static final String NOT_FOUND_MESSAGE = "The user does not exist";

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user/checkuser", produces = "application/json", consumes = "application/json")
    public JsonResponse<String> checkUser(@RequestBody User info, HttpServletRequest request,
                                          HttpServletResponse response) throws MsgException {
        if (info != null) {
            info = userService.getUserByEmailPassword(info.getEmail(),
                    SecurityHelper.stringMD5(info.getPassword()));
            if (info != null) {
                String authCode = UUIDHelper.getUUID();
                info.setAuthCode(authCode);
                info.setAuthCodeExpire(DateHelper.NowAddSeconds(userService.getAuthExpire()));
                userService.save(info);

                UserAccessUtil.getInstance().setSSOCookie(response, info.getAuthCode(), info.getUserName(),
                        userService.getAuthExpire());
                UserAccessUtil.getInstance().setUserNameCookie(response, info.getUserName(), userService.getCookieExpire());
                return new JsonResponse<>("CHECK_DONE");
            } else {
                return new JsonResponse<>("CHECK_FAIL");
            }
        } else {
            throw new MsgException(NOT_FOUND_CODE, NOT_FOUND_MESSAGE);
        }
    }
}
