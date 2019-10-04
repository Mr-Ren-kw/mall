package com.j4h.mall.service.admin;

import java.util.List;

public interface AdminService {

    String getAdminAvatarByUsername(String principal);

    List<String> getPermissionByUsername(String principal);

    List<String> getRolesByUsername(String principal);
}
