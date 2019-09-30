package com.j4h.mall.model;

import com.j4h.mall.model.goods.GoodItem;

import java.util.List;

/**
 * 商品列表返回的data
 */
public class PageBean<T> {
    private List<T> items;
    private long total;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "GoodInfo{" +
                "items=" + items +
                ", total=" + total +
                '}';
    }
}
