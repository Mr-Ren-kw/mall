package com.j4h.mall.model.wx.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.j4h.mall.model.wx.user.HandleOption;

import java.util.Date;

public class WxOrder {
    String consignee;
    String address;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    Date addTime;
    String orderSn;
    double actualPrice;
    String mobile;
    String orderStatusTest;
    double goodsPrice;
    double couponPrice;
    int id;
    double freightPrice;
    HandleOption handleOption;
    int statu;

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOrderStatusTest() {
        return orderStatusTest;
    }

    public void setOrderStatusTest(String orderStatusTest) {
        this.orderStatusTest = orderStatusTest;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public double getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(double couponPrice) {
        this.couponPrice = couponPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(double freightPrice) {
        this.freightPrice = freightPrice;
    }

    public HandleOption getHandleOption() {
        return handleOption;
    }

    public void setHandleOption(HandleOption handleOption) {
        this.handleOption = handleOption;
    }
}
