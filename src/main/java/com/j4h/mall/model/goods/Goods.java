package com.j4h.mall.model.goods;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;



public class Goods {

    /**
     * brief : Jk制服
     * keywords : jk
     * goodsSn : 000001
     * isNew : true
     * picUrl : http://192.168.2.100:8081/wx/storage/fetch/7l3jo2nuelk5qkxw4f2c.jpg
     * unit : 件
     * brandId : 1001000
     * name : jk制服
     * counterPrice : 100
     * detail : <p>没什么好介绍的！</p>
     * isOnSale : true
     * retailPrice : 200
     * gallery : []
     * categoryId : 1020009
     * isHot : false
     */
    private String brief;
    private String keywords;
    private String goodsSn;
    private boolean isNew;
    private String picUrl;
    private String unit;
    private int brandId;
    private String name;
    private Double counterPrice;
    private String detail;
    private boolean isOnSale;
    private Double retailPrice;
    private String[] gallery;
    private int categoryId;
    private boolean isHot;
    private int id;
    private boolean deleted;
    private int sortOrder;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date addTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setIsOnSale(boolean isOnSale) {
        this.isOnSale = isOnSale;
    }


    public void setGallery(String[] gallery) {
        this.gallery = gallery;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setIsHot(boolean isHot) {
        this.isHot = isHot;
    }

    public String getBrief() {
        return brief;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public boolean getIsNew() {
        return isNew;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getUnit() {
        return unit;
    }

    public int getBrandId() {
        return brandId;
    }

    public String getName() {
        return name;
    }


    public String getDetail() {
        return detail;
    }

    public boolean getIsOnSale() {
        return isOnSale;
    }


    public String[] getGallery() {
        return gallery;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public boolean getIsHot() {
        return isHot;
    }

    public Double getCounterPrice() {
        return counterPrice;
    }

    public void setCounterPrice(Double counterPrice) {
        this.counterPrice = counterPrice;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }
}
