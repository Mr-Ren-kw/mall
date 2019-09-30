package com.j4h.mall.model.mall;

import java.util.List;

public class RegionCity {
    private List<RegionArea> children;
    private int code;
    private int id;
    private String name;
    private int type;

    public List<RegionArea> getChildren() {
        return children;
    }

    public void setChildren(List<RegionArea> children) {
        this.children = children;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
