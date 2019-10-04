package com.j4h.mall.service.admin;

import com.j4h.mall.mapper.admin.AdminMapper;
import com.j4h.mall.model.admin.Admin;
import com.j4h.mall.model.admin.AdminPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<String> permissionByRoleIds = adminMapper.getPermissionByRoleIds(ids);
        if(permissionByRoleIds.contains("*")) {
            ArrayList<String> strings = new ArrayList<>();
            strings.add("*");
            return strings;
        }
        return adminMapper.getPermsByPermissions(permissionByRoleIds);
    }

    @Override
    public List<String> getRolesByUsername(String principal) {
        Admin admin = adminMapper.getRoleIdsByUsername(principal);
        int[] ids = admin.getRoleIds();
        return adminMapper.getRolesByIds(ids);
    }

    @Override
    public int alterAdminPassword(String username, AdminPassword password) {
        String old = password.getOldPassword();
        String oldFromDb = adminMapper.getPasswordByUsername(username);
        if(old.equals(oldFromDb)) {
            adminMapper.updatePasswordByUsername(username, password.getNewPassword());
            return 0;
        }
        return 1;
    }


}
