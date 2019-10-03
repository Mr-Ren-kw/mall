package com.j4h.mall.controller.system;

import com.j4h.mall.model.system.*;
import com.j4h.mall.service.system.AdminService;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/2 23:51
 */
@RestController
@CrossOrigin
@RequestMapping("/admin/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/create")
    public BaseRespVo insertAdmin(@RequestBody Admin admin){
        Admin admin1 = adminService.insertAdmin(admin);
        return BaseRespVo.ok(admin1);
    }

    @GetMapping("/list")
    public BaseRespVo showAdminList(AdminQuery adminQuery){
        AdminList adminList = adminService.queryAdmin(adminQuery);
        return BaseRespVo.ok(adminList);
    }
}
