package com.j4h.mall.util;

import java.util.UUID;

/**
 * @author sld
 * @version 1.0
 * @date 2019/9/30 23:18
 */
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
