package com.j4h.mall.model;

import com.j4h.mall.model.user.User;

import java.util.List;

public class PageBean<T> {
    int total;
    List<T> items;

    @Override
    public String toString() {
        return "PageBean{" +
                "total=" + total +
                ", items=" + items +
                '}';
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
