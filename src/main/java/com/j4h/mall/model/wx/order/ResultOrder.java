package com.j4h.mall.model.wx.order;

import com.j4h.mall.model.mall.order.OrderGoods;

import java.util.List;

public class ResultOrder {
    WxOrder orderInfo;
    List<OrderGoods> orderGoods;

    public WxOrder getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(WxOrder orderInfo) {
        this.orderInfo = orderInfo;
    }

    public List<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }
}
