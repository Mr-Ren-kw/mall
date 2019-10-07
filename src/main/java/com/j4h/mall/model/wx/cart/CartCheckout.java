package com.j4h.mall.model.wx.cart;

import com.j4h.mall.model.wx.address.WxAddressDetail;

import java.util.List;

public class CartCheckout {
    private double grouponPrice;
    private int grouponRulesId;
    private WxAddressDetail checkedAddress;
    private double actualPrice;
    private double orderTotalPrice;
    private double couponPrice;
    private int availableCouponLength;
    private int couponId;
    private double freightPrice;
    private List<Cart> checkedGoodsList;
    private double goodsTotalPrice;
    private int addressId;

    public double getGrouponPrice() {
        return grouponPrice;
    }

    public void setGrouponPrice(double grouponPrice) {
        this.grouponPrice = grouponPrice;
    }

    public int getGrouponRulesId() {
        return grouponRulesId;
    }

    public void setGrouponRulesId(int grouponRulesId) {
        this.grouponRulesId = grouponRulesId;
    }

    public WxAddressDetail getCheckedAddress() {
        return checkedAddress;
    }

    public void setCheckedAddress(WxAddressDetail checkedAddress) {
        this.checkedAddress = checkedAddress;
    }

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public double getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(double couponPrice) {
        this.couponPrice = couponPrice;
    }

    public int getAvailableCouponLength() {
        return availableCouponLength;
    }

    public void setAvailableCouponLength(int availableCouponLength) {
        this.availableCouponLength = availableCouponLength;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public double getFreightPrice() {
        return freightPrice;
    }

    public void setFreightPrice(double freightPrice) {
        this.freightPrice = freightPrice;
    }

    public List<Cart> getCheckedGoodsList() {
        return checkedGoodsList;
    }

    public void setCheckedGoodsList(List<Cart> checkedGoodsList) {
        this.checkedGoodsList = checkedGoodsList;
    }

    public double getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(double goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
