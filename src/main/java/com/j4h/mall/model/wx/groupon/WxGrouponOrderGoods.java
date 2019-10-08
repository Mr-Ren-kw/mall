package com.j4h.mall.model.wx.groupon;

import java.util.List;

public class WxGrouponOrderGoods {
    int goodsId;
    String goodsName;
    String[] goodsSpecificationsValues;
    int id;
    int number;
    int orderId;
    String picUrl;
    double retailPrice;

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String[] getGoodsSpecificationsValues() {
        return goodsSpecificationsValues;
    }

    public void setGoodsSpecificationsValues(String[] goodsSpecificationsValues) {
        this.goodsSpecificationsValues = goodsSpecificationsValues;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }
}
