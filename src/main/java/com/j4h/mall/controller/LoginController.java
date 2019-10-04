package com.j4h.mall.controller;

import com.j4h.mall.model.AdminInfo;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.LoginVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/auth")
public class LoginController {
    @RequestMapping("/login")
    public BaseRespVo login(@RequestBody LoginVo loginVo) {
        String username = loginVo.getUsername();
        String password = loginVo.getPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return BaseRespVo.LoginFail();
        }
        Serializable id = subject.getSession().getId();
        return BaseRespVo.ok(id);
    }
    @RequestMapping("/info")
    public BaseRespVo info(String token) {
        AdminInfo adminInfo = new AdminInfo();
        adminInfo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        adminInfo.setName("admin123");
        List<String> perms = new ArrayList<>();
        perms.add("*");
        adminInfo.setPerms(perms);
        List<String> roles = new ArrayList<>();
        roles.add("超级管理员");
        adminInfo.setRoles(roles);
        return BaseRespVo.ok(adminInfo);
    }
}
