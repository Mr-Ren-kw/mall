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
}
