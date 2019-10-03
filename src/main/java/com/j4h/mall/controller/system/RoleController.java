package com.j4h.mall.controller.system;

import com.j4h.mall.model.system.Role;
import com.j4h.mall.model.system.RoleList;
import com.j4h.mall.model.system.StorageList;
import com.j4h.mall.model.system.StorageQuery;
import com.j4h.mall.service.system.RoleService;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/3 17:30
 */
@RestController
@CrossOrigin
@RequestMapping("/admin/role")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/list")
    public BaseRespVo showRoleList(StorageQuery storageQuery){
        RoleList roleList = roleService.queryRole(storageQuery);
        return BaseRespVo.ok(roleList);
    }

    @PostMapping("/create")
    public BaseRespVo addRole(@RequestBody Role role){
        Role role1 = roleService.addRole(role);
        return BaseRespVo.ok(role1);
    }
}
