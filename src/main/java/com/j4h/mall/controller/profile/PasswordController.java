package com.j4h.mall.controller.profile;

import com.j4h.mall.mapper.admin.AdminMapper;
import com.j4h.mall.model.admin.AdminPassword;
import com.j4h.mall.service.admin.AdminService;
import com.j4h.mall.vo.BaseRespVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 就一个Url
 */
@RestController
@RequestMapping("admin/profile")
public class PasswordController {

    @Autowired
    AdminService adminService;

    @RequestMapping("password")
    public BaseRespVo alterPassword(@RequestBody AdminPassword password) {
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        int res = adminService.alterAdminPassword(username, password);
        BaseRespVo err = new BaseRespVo();
        if(res == 0) {
            return BaseRespVo.ok(null);
        } else{
            if(res == 1) {
                err = new BaseRespVo(null, "账号密码不对", 605);
            }
        }
        return err;
    }
}
