package com.sofast.application.entity;


import com.sofast.application.model.User;

/*
 *
 * @author fjiang
 * @description 
 * @date 8/4/16
 */
public class UserContextHolder {

    private UserContextHolder(){

    }
    private static final ThreadLocal<User> contextHolder = new ThreadLocal<>();

    public static void setUser(User sd) {
        contextHolder.set(sd);
    }

    public static User getUser() {
        return contextHolder.get();
    }

    public static void clearUser() {
        contextHolder.remove();
    }
}
