
package com.sofast.application.util;

import lombok.extern.slf4j.Slf4j;

/*
 *
 * @author fjiang
 * @description 
 * @date 7/20/16
 */
@Slf4j
public final class UserAccessUtil extends BaseAccessUtil {

    private static final String STAFF_AUTH_CODE = "STUDENT_AUTH_CODE";
    private static final String STAFF_COOKIE_NAME = "STUDENT_DISPLAY_NAME";

    private static final UserAccessUtil ourInstance = new UserAccessUtil();

    public static UserAccessUtil getInstance() {
        return ourInstance;
    }

    private UserAccessUtil() {
    }

    @Override
    protected String getAuthCode(){
        return STAFF_AUTH_CODE;
    }

    @Override
    protected String getNameCookie(){
        return STAFF_COOKIE_NAME;
    }
}
