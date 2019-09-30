package com.j4h.mall.vo.systemManageVo;

import java.util.List;

public class AdminVo {

    /**
     * roleIds : [3]
     * id : 21
     * avatar : http://192.168.2.100:8081/wx/storage/fetch/4vekgosssa1av18yqonb.jpg
     * username : yanhua
     */
    private List<Integer> roleIds;
    private int id;
    private String avatar;
    private String username;

    public void setRoleIds(List<Integer> roleIds) {
        this.roleIds = roleIds;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public int getId() {
        return id;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getUsername() {
        return username;
    }
}
