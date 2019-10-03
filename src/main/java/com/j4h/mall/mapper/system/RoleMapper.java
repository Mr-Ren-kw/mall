package com.j4h.mall.mapper.system;

import com.j4h.mall.model.system.Role;
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
}
