package com.j4h.mall.mapper.system;

import com.j4h.mall.model.system.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/3 16:40
 */
public interface AdminMapper {
    int insertAdmin(@Param("admin") Admin admin);
    Admin queryAdminByNameAndPassword(String name,String password);
    List<Admin> queryAdmin(String username);
    int updateAdmin(Admin admin);
    void deleteAdminById(int id);
    List<Admin> queryAdminByUsername(String username);
    Admin queryAdminById(int id);
    String getPasswordByUsername(@Param("username") String username);

    List<String> getPermissionByRoleIds(@Param("ids") int[] roleIds);

    com.j4h.mall.model.admin.Admin getRoleIdsByUsername(@Param("username") String primaryPrincipal);

    List<String> getRolesByIds(@Param("ids") int[] ids);

    String getAvatarByUsername(@Param("username") String principal);

    void updatePasswordByUsername(@Param("username") String username, @Param("password") String password);

    List<String> getPermsByPermissions(@Param("permissions") List<String> permissionByRoleIds);
}
