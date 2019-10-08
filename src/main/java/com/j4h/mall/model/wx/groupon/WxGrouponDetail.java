package com.j4h.mall.model.wx.groupon;

import java.util.List;

public class WxGrouponDetail {
    WxGrouponCreator creator;
    WxMyGroupon groupon;
    List<WxGrouponJoiners> joiners;
    int linkGrouponId;
    List<WxGrouponOrderGoods> orderGoods;
    WxGrouponOrderInfo orderInfo;
    WxMyRules rules;

    public WxGrouponCreator getCreator() {
        return creator;
    }

    public void setCreator(WxGrouponCreator creator) {
        this.creator = creator;
    }

    public WxMyGroupon getGroupon() {
        return groupon;
    }

    public void setGroupon(WxMyGroupon groupon) {
        this.groupon = groupon;
    }

    public List<WxGrouponJoiners> getJoiners() {
        return joiners;
    }

    public void setJoiners(List<WxGrouponJoiners> joiners) {
        this.joiners = joiners;
    }

    public int getLinkGrouponId() {
        return linkGrouponId;
    }

    public void setLinkGrouponId(int linkGrouponId) {
        this.linkGrouponId = linkGrouponId;
    }

    public List<WxGrouponOrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<WxGrouponOrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public WxGrouponOrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(WxGrouponOrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public WxMyRules getRules() {
        return rules;
    }

    public void setRules(WxMyRules rules) {
        this.rules = rules;
    }
}
