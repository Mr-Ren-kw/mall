package com.j4h.mall.service.wx.user;

import com.j4h.mall.util.UserInfo;

public interface WxUserSerivce {
    UserInfo getUserInfoByUsernameAndPassword(String username, String password);

}
