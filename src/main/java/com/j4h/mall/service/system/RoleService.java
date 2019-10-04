package com.j4h.mall.service.system;

import com.j4h.mall.model.system.*;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/3 17:31
 */
public interface RoleService {
    RoleList queryRole(StorageQuery storageQuery);
    Role addRole(Role role);
    void deleteRole(Role role);
    List<RoleVo> getAllRole();
    PermissionVo getPermissionsByRoleId(int roleId);
    boolean updatePermissions(PermissionsPostVo permissionsPostVo);
}
