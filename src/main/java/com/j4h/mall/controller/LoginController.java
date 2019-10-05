package com.j4h.mall.controller;

import com.j4h.mall.model.AdminInfo;
import com.j4h.mall.service.admin.AdminService;
import com.j4h.mall.shiro.CustomToken;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.LoginVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/admin/auth")
public class LoginController {
    @Autowired
    @Qualifier("yytAdminService")
    AdminService adminService;

    @RequestMapping("/login")
    public BaseRespVo login(@RequestBody(required = false) LoginVo loginVo) {
//    public BaseRespVo login(String username, String password) {
        if(loginVo == null) {
            return new BaseRespVo(null, "请重新登陆", 500);
        }
        String username = loginVo.getUsername();
        String password = loginVo.getPassword();
        CustomToken token = new CustomToken(username, password, "admin");
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return new BaseRespVo(null, "用户帐号或密码不正确", 605);
        }
        Serializable id = subject.getSession().getId();
        return BaseRespVo.ok(id);
    }

    @RequestMapping("/info")
    public BaseRespVo info(String token) {
        Subject subject = SecurityUtils.getSubject();
        String principal = (String) subject.getPrincipal();
        AdminInfo adminInfo = new AdminInfo();
        String avatar = adminService.getAdminAvatarByUsername(principal);
        adminInfo.setAvatar(avatar);
        adminInfo.setName(principal);
        List<String> perms = adminService.getPermissionByUsername(principal);
        adminInfo.setPerms(perms);
        List<String> roles = adminService.getRolesByUsername(principal);
        adminInfo.setRoles(roles);
        return BaseRespVo.ok(adminInfo);
    }

    @RequestMapping("/logout")
    public BaseRespVo logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return BaseRespVo.ok(null);
    }
}
