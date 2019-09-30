package com.j4h.mall.vo.goods;

import java.util.List;

public class GoodsVo {

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
    private String counterPrice;
    private String detail;
    private boolean isOnSale;
    private String retailPrice;
    private List<String> gallery;
    private int categoryId;
    private boolean isHot;
    private int id;

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

    public void setCounterPrice(String counterPrice) {
        this.counterPrice = counterPrice;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setIsOnSale(boolean isOnSale) {
        this.isOnSale = isOnSale;
    }

    public void setRetailPrice(String retailPrice) {
        this.retailPrice = retailPrice;
    }

    public void setGallery(List<String> gallery) {
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

    public String getCounterPrice() {
        return counterPrice;
    }

    public String getDetail() {
        return detail;
    }

    public boolean getIsOnSale() {
        return isOnSale;
    }

    public String getRetailPrice() {
        return retailPrice;
    }

    public List<?> getGallery() {
        return gallery;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public boolean getIsHot() {
        return isHot;
    }
}
