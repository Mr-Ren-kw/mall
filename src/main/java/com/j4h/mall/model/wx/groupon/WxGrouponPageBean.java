package com.j4h.mall.model.wx.groupon;

import java.util.List;

public class WxGrouponPageBean<T> {
    private int count;
    private List<T> data;

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

    @Override
    public String toString() {
        return "WxGrouponPageBean{" +
                "count=" + count +
                ", data=" + data +
                '}';
    }
}
