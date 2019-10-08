package com.j4h.mall.model.wx.groupon;

import java.util.List;

public class WxGrouponPageBean2 {
    int groupon_member;
    double groupon_price;
    WxGrouponGoodsBean goods;

    public int getGroupon_member() {
        return groupon_member;
    }

    public void setGroupon_member(int groupon_member) {
        this.groupon_member = groupon_member;
    }

    public double getGroupon_price() {
        return groupon_price;
    }

    public void setGroupon_price(double groupon_price) {
        this.groupon_price = groupon_price;
    }

    public WxGrouponGoodsBean getGoods() {
        return goods;
    }

    public void setGoods(WxGrouponGoodsBean goods) {
        this.goods = goods;
    }
}
