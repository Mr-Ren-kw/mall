package com.j4h.mall.service.wx.auth;

import com.j4h.mall.vo.wx.RegisterVo;

import java.io.Serializable;

public interface WxAuthService {
    Serializable getRegCaptcha(String mobile);

    int registerUser(RegisterVo registerVo);
}
