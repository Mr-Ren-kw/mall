package com.j4h.mall.model.system;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/3 21:26
 */
public class AdminList {
    private long total;
    private List<Admin> items;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Admin> getItems() {
        return items;
    }

    public void setItems(List<Admin> items) {
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
