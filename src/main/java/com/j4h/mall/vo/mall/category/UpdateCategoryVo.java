package com.j4h.mall.vo.mall.category;

import com.j4h.mall.model.mall.category.L2Category;

public class UpdateCategoryVo {
    private String desc;
    private String iconUrl;
    private int id;
    private String keywords;
    private String level;
    private String name;
    private String picUrl;
    private int pid;
    private L2Category[] children;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public L2Category[] getChildren() {
        return children;
    }

    public void setChildren(L2Category[] children) {
        this.children = children;
    }
}