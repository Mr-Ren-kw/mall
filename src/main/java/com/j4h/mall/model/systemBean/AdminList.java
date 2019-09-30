package com.j4h.mall.model.systemBean;

import java.util.List;

public class AdminList {
    int total;
    List<AdminOfSystemManage> items;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<AdminOfSystemManage> getItems() {
        return items;
    }

    public void setItems(List<AdminOfSystemManage> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "AdminList{" +
                "total=" + total +
                ", items=" + items +
                '}';
    }
}
