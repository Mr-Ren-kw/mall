package com.j4h.mall.model.wx.coupon;

import java.util.Date;

public class WxMyCouChangeStatus {
    int id;
    Date endTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
