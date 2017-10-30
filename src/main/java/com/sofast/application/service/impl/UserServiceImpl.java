package com.sofast.application.service.impl;

import com.sofast.application.dao.UserDao;
import com.sofast.application.model.User;
import com.sofast.application.service.UserService;
import com.sofast.application.util.SecurityHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService {

    @Value("${cookie_expire}")
    private int cookieExpire;

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
        this.crudRepository = userDao;
    }

    /**
     * 默认设置cookie的过期时间为15分钟
     * @return
     */
    @Override
    public int getCookieExpire() {
        return cookieExpire * 2;
    }

    /**
     * 默认设置cookie的过期时间为25分钟
     * @return
     */
    @Override
    public int getAuthExpire() {
        return cookieExpire * 2;
    }

    @Override
    public int getAuthRefresh() {
        return cookieExpire ;
    }

    @Override
    public User getUserByAuthCode(String authCode) {
        return userDao.findByAuthCode(authCode);
    }

    @Override
    public User getUserByEmailPassword(String email, String password) {
        String encryptPassword = SecurityHelper.stringMD5(password);
        return userDao.findByEmailAndPassword(email, encryptPassword);
    }
}
