package com.j4h.mall.vo.extension.BeanForData;

import java.util.List;

public class PageData<T> {
    private int total;
    private List<T> items;

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
