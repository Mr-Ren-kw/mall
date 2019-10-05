package com.j4h.mall.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

public class LoginOrNotUtils {
    // 需要获取userId的时候使用
    public static Integer getUserId() {
        Session session = SecurityUtils.getSubject().getSession();
        return (Integer) session.getAttribute("userId");
    }

    // 只需要判断用户是否登录时使用
    public static boolean isLogin() {
        Session session = SecurityUtils.getSubject().getSession();
        return session.getAttribute("userId") != null;
    }
}
