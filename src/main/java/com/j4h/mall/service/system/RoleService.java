package com.j4h.mall.service.system;

import com.j4h.mall.model.system.Role;
import com.j4h.mall.model.system.RoleList;
import com.j4h.mall.model.system.RoleVo;
import com.j4h.mall.model.system.StorageQuery;

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
}
