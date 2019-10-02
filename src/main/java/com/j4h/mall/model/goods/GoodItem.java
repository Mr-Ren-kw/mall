package com.j4h.mall.model.goods;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;



public class GoodItem {

    /**
     * brief :
     * keywords :
     * addTime : 2019-09-30 04:04:54
     * goodsSn : 23333
     * updateTime : 2019-09-30 04:04:54
     * isNew : false
     * picUrl :
     * unit : ’件‘
     * deleted : false
     * brandId : 0
     * sortOrder : 100
     * name : test
     * counterPrice : 0.0
     * id : 1181020
     * isOnSale : true
     * retailPrice : 100000.0
     * categoryId : 0
     * gallery : []
     * isHot : false
     */
    private String brief;
    private String keywords;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date addTime;
    private String goodsSn;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    private boolean isNew;
    private String picUrl;
    private String unit;
    private boolean deleted;
    private int brandId;
    private int sortOrder;
    private String name;
    private double counterPrice;
    private int id;
    private boolean isOnSale;
    private double retailPrice;
    private int categoryId;
    // 坑
    private String gallery;
    private boolean isHot;

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(boolean aNew) {
        isNew = aNew;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCounterPrice() {
        return counterPrice;
    }

    public void setCounterPrice(double counterPrice) {
        this.counterPrice = counterPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(boolean onSale) {
        isOnSale = onSale;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getGallery() {
        return gallery;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
    }

    public boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(boolean hot) {
        isHot = hot;
    }
}
