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
        // 先判断这个名字是否已经存在
        String username = admin.getUsername();
        if (adminService.queryAdminByUsername(username).isEmpty()){
            Admin admin1 = adminService.insertAdmin(admin);
            return BaseRespVo.ok(admin1);
        }
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setErrno(602);
        baseRespVo.setErrmsg("管理员已存在");
        return  baseRespVo;
    }

    @GetMapping("/list")
    public BaseRespVo showAdminList(AdminQuery adminQuery){
        AdminList adminList = adminService.queryAdmin(adminQuery);
        return BaseRespVo.ok(adminList);
    }

    @PostMapping("/update")
    public BaseRespVo updateAdmin(@RequestBody Admin admin){
        Admin admin1 = adminService.updateAdmin(admin);
        if (admin1 != null){
            return BaseRespVo.ok(admin1);
        }
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setErrno(602);
        baseRespVo.setErrmsg("管理员已存在");
        return  baseRespVo;
    }

    @PostMapping("/delete")
    public BaseRespVo deleteAdmin(@RequestBody Admin admin){
        adminService.deleteAdmin(admin);
        return BaseRespVo.ok(null);
    }
}
