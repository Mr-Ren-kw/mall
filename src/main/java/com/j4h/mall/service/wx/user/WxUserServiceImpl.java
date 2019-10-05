package com.j4h.mall.service.wx.user;

import com.j4h.mall.mapper.user.UserMapper;
import com.j4h.mall.util.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxUserServiceImpl implements WxUserSerivce {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserInfo getUserInfoByUsernameAndPassword(String username, String password) {
        if(username == null || "".equals(username.trim())) {
            return null;
        }
        return userMapper.getUserInfoByUsernameAndPassword(username, password);
    }
}
