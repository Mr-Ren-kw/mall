package com.j4h.mall.service.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.system.AdminMapper;
import com.j4h.mall.model.system.Admin;
import com.j4h.mall.model.system.AdminList;
import com.j4h.mall.model.system.AdminQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/2 23:53
 */
@Service("sldAdminService")
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

    @Override
    public AdminList queryAdmin(AdminQuery adminQuery) {
        int start = adminQuery.getPage();
        int limit = adminQuery.getLimit();
        String sort = adminQuery.getSort();
        String order = adminQuery.getOrder();
        PageHelper.startPage(start,limit,sort + " " + order);
        String username = adminQuery.getUsername();
        if (username == null){
            username = "";
        }
        username = "%" + username + "%";
        List<Admin> admins = adminMapper.queryAdmin(username);
        PageInfo<Admin> adminPageInfo = new PageInfo<>(admins);
        long total = adminPageInfo.getTotal();
        AdminList adminList = new AdminList();
        adminList.setTotal(total);
        adminList.setItems(admins);
        return adminList;
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        // 先通过id获取
        Admin admin2 = adminMapper.queryAdminById(admin.getId());
        // 如果用户名修改就需要判断
        if (!admin.getUsername().equals(admin2.getUsername())){
            if(!adminMapper.queryAdminByUsername(admin.getUsername()).isEmpty()){
                // 有重名
                return null;
            }
        }
        adminMapper.updateAdmin(admin);
        String username = admin.getUsername();
        String password = admin.getPassword();
        Admin admin1 = adminMapper.queryAdminByNameAndPassword(username, password);
        return admin1;
    }

    @Override
    public void deleteAdmin(Admin admin) {
        int id = admin.getId();
        adminMapper.deleteAdminById(id);
    }

    @Override
    public List<Admin> queryAdminByUsername(String username) {
        return adminMapper.queryAdminByUsername(username);
    }
}
