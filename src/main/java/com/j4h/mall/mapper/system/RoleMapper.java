package com.j4h.mall.mapper.system;

import com.j4h.mall.model.system.Role;
import com.j4h.mall.model.system.RoleVo;
import com.j4h.mall.model.system.SystemPermissions;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/3 17:32
 */
public interface RoleMapper {
    List<Role> queryRole(String name);
    void insertRole(@Param("role") Role role);
    Role queryRoleById(int id);
    void deleteRole(Role role);
    List<RoleVo> getAllRole();
    String[] getPermissionsByRoleId(int roleId);
    List<SystemPermissions> getAllPermissions();
    void deletePermissionByRoleId(int roleId);
    int insertPermissionByRoleIdAndPermission(@Param("roleId") int roleId,@Param("permissions") String[] permissions);
}