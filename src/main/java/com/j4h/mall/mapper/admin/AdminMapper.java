package com.j4h.mall.mapper.admin;

import com.j4h.mall.model.admin.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    String getPasswordByUsername(@Param("username") String username);

    List<String> getPermissionByRoleIds(@Param("ids") int[] roleIds);

    Admin getRoleIdsByUsername(@Param("username") String primaryPrincipal);

    List<String> getRolesByIds(@Param("ids") int[] ids);

    String getAvatarByUsername(@Param("username") String principal);
}
