package com.j4h.mall.model.wx.home;

import com.j4h.mall.model.goods.Goods;

import java.math.BigDecimal;

public class GrouponGoods {
    private int groupon_member;
    private BigDecimal groupon_price;
    private Goods goods;

    public int getGroupon_member() {
        return groupon_member;
    }

    public void setGroupon_member(int groupon_member) {
        this.groupon_member = groupon_member;
    }

    public BigDecimal getGroupon_price() {
        return groupon_price;
    }

    public void setGroupon_price(BigDecimal groupon_price) {
        this.groupon_price = groupon_price;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
