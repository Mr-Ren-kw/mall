package com.j4h.mall.mapper.system;

import com.j4h.mall.model.system.Admin;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/3 16:40
 */
public interface AdminMapper {
    int insertAdmin(Admin admin);
    Admin queryAdminByNameAndPassword(String name,String password);
}
