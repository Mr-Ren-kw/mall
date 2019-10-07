package com.j4h.mall.model.wx.coupon;

import java.util.List;

public class WxCouponList<T> {
    int count;
    List<T> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
