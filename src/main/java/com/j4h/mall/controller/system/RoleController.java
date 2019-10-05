package com.j4h.mall.controller.system;

import com.j4h.mall.model.system.*;
import com.j4h.mall.service.system.RoleService;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/delete")
    public BaseRespVo deleteRole(@RequestBody Role role){
        roleService.deleteRole(role);
        return BaseRespVo.ok(null);
    }

    @GetMapping("/options")
    public BaseRespVo optionsRole(){
        List<RoleVo> data = roleService.getAllRole();
        return BaseRespVo.ok(data);
    }

    @GetMapping("/permissions")
    public BaseRespVo getPermissionsByRoleId(int roleId){
        PermissionVo permissionsByRoleId = roleService.getPermissionsByRoleId(roleId);
        return BaseRespVo.ok(permissionsByRoleId);
    }

    @PostMapping("/permissions")
    public BaseRespVo getPermissions(@RequestBody PermissionsPostVo permissionsPostVo){
        int roleId = permissionsPostVo.getRoleId();
        if (roleId == 1){
            BaseRespVo baseRespVo = new BaseRespVo();
            baseRespVo.setErrno(641);
            baseRespVo.setErrmsg("当前角色的超级权限不能变更");
            return baseRespVo;
        }
        boolean b = roleService.updatePermissions(permissionsPostVo);
        if (b){
            return BaseRespVo.ok(null);
        }
        BaseRespVo baseRespVo = new BaseRespVo();
        baseRespVo.setErrno(666);
        baseRespVo.setErrmsg("修改失败");
        return baseRespVo;
    }
}
