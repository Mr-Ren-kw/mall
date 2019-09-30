package com.j4h.mall.model.systemManageBean;

import java.util.List;

public class AdminOfSystemManage {

    /**
     * roleIds : [3]
     * id : 21
     * avatar : http://192.168.2.100:8081/wx/storage/fetch/4vekgosssa1av18yqonb.jpg
     * username : yanhua
     */
    private String roleIds;
    private int id;
    private String avatar;
    private String username;

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
