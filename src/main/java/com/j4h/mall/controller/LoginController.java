package com.j4h.mall.controller;

import com.j4h.mall.model.AdminInfo;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.LoginVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/auth")
public class LoginController {
    @RequestMapping("/login")
    public BaseRespVo login(@RequestBody LoginVo loginVo) {
        return BaseRespVo.ok("4d663454-a6d5-40d8-8e11-7f5d1ce92b5a");
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
