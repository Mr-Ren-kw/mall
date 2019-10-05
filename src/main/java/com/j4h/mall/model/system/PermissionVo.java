package com.j4h.mall.model.system;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/4 19:53
 */
public class PermissionVo {
    String[] assignedPermissions;
    List<SystemPermissions> systemPermissions;

    public String[] getAssignedPermissions() {
        return assignedPermissions;
    }

    public void setAssignedPermissions(String[] assignedPermissions) {
        this.assignedPermissions = assignedPermissions;
    }

    public List<SystemPermissions> getSystemPermissions() {
        return systemPermissions;
    }

    public void setSystemPermissions(List<SystemPermissions> systemPermissions) {
        this.systemPermissions = systemPermissions;
    }
}
