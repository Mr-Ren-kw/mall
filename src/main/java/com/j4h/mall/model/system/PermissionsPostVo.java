package com.j4h.mall.model.system;

/**
 * /admin/role/permissions post 传进来的数据
 * @author sld
 * @version 1.0
 * @date 2019/10/4 20:07
 */
public class PermissionsPostVo {
    int roleId;
    String[] permissions;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String[] getPermissions() {
        return permissions;
    }

    public void setPermissions(String[] permissions) {
        this.permissions = permissions;
    }
}
