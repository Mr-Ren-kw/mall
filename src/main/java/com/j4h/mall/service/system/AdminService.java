package com.j4h.mall.service.system;

import com.j4h.mall.model.system.Admin;
import com.j4h.mall.model.system.AdminList;
import com.j4h.mall.model.system.AdminQuery;
import com.j4h.mall.model.system.StorageQuery;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/2 23:53
 */
public interface AdminService {
    Admin insertAdmin(Admin admin);
    AdminList queryAdmin(AdminQuery adminQuery);
    Admin updateAdmin(Admin admin);
    void deleteAdmin(Admin admin);
    List<Admin> queryAdminByUsername(String username);
}
