package com.sofast.application.service;

import com.sofast.application.model.User;

public interface UserService extends BaseService<User, String> {

    int getCookieExpire();

    int getAuthExpire();

    int getAuthRefresh();

    User getUserByAuthCode(String authCode);

    User getUserByEmailPassword(String email, String password);

}
