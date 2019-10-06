package com.j4h.mall.model.wx.user;

import java.util.List;

public class AllGoodsList {
    List<UserOrderDetailsList> data;
    int count;
    int totalPages;


    public List<UserOrderDetailsList> getData() {
        return data;
    }

    public void setData(List<UserOrderDetailsList> data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
