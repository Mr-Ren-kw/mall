package com.j4h.mall.util;

public class MyStringUtils {
    public static String searchKeyword(String s) {
        if (s != null && !"".equals(s)) {
            s = "%" + s + "%";
        }
        return s;
    }
}
