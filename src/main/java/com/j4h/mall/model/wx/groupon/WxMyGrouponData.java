package com.j4h.mall.model.wx.groupon;

import java.util.List;

public class WxMyGrouponData {
    double actualPrice;
    String crearot;
    List<WxMyGrouponGoodsBean> goodsList;
    WxMyGroupon groupon;
    WxMyHandleOption handleOption;
    int id;
    boolean isCreator;
    int joinerCount;
    int orderId;
    String orderSn;
    String orderStatusText;
    WxMyRules rules;

    public double getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(double actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getCrearot() {
        return crearot;
    }

    public void setCrearot(String crearot) {
        this.crearot = crearot;
    }

    public List<WxMyGrouponGoodsBean> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<WxMyGrouponGoodsBean> goodsList) {
        this.goodsList = goodsList;
    }

    public WxMyGroupon getGroupon() {
        return groupon;
    }

    public void setGroupon(WxMyGroupon groupon) {
        this.groupon = groupon;
    }

    public WxMyHandleOption getHandleOption() {
        return handleOption;
    }

    public void setHandleOption(WxMyHandleOption handleOption) {
        this.handleOption = handleOption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCreator() {
        return isCreator;
    }

    public void setCreator(boolean creator) {
        isCreator = creator;
    }

    public int getJoinerCount() {
        return joinerCount;
    }

    public void setJoinerCount(int joinerCount) {
        this.joinerCount = joinerCount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getOrderStatusText() {
        return orderStatusText;
    }

    public void setOrderStatusText(String orderStatusText) {
        this.orderStatusText = orderStatusText;
    }

    public WxMyRules getRules() {
        return rules;
    }

    public void setRules(WxMyRules rules) {
        this.rules = rules;
    }
}
