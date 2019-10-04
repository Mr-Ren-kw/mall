package com.j4h.mall.service.admin;

import com.j4h.mall.mapper.admin.AdminMapper;
import com.j4h.mall.model.admin.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public String getAdminAvatarByUsername(String principal) {
        return adminMapper.getAvatarByUsername(principal);
    }

    @Override
    public List<String> getPermissionByUsername(String principal) {
        Admin admin = adminMapper.getRoleIdsByUsername(principal);
        int[] ids = admin.getRoleIds();
        return adminMapper.getPermissionByRoleIds(ids);
    }

    @Override
    public List<String> getRolesByUsername(String principal) {
        Admin admin = adminMapper.getRoleIdsByUsername(principal);
        int[] ids = admin.getRoleIds();
        return adminMapper.getRolesByIds(ids);
    }


}
