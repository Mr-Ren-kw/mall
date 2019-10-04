package com.j4h.mall.model.mall.brand;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Brand {
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss",timezone = "GMT+8")
    private Date addTime;
    private boolean deleted;
    private String desc;
    private double floorPrice;
    private int id;
    private String name;
    private String picUrl;
    private int sortOrder;
    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss",timezone = "GMT+8")
    private Date updateTime;

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(double floorPrice) {
        this.floorPrice = floorPrice;
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

}
