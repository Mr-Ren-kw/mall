package com.j4h.mall.service.system;

import com.j4h.mall.mapper.system.AdminMapper;
import com.j4h.mall.model.system.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/2 23:53
 */
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin insertAdmin(Admin admin) {
        admin.setAddTime(new Date());
        int i = adminMapper.insertAdmin(admin);
        String username = admin.getUsername();
        String password = admin.getPassword();
        Admin admin1 = adminMapper.queryAdminByNameAndPassword(username, password);
        return admin1;
    }
}
