package com.j4h.mall.model.system;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/2 20:11
 */
public class StorageList {
    private long total;
    private List<Storage> items;


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Storage> getItems() {
        return items;
    }

    public void setItems(List<Storage> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "StorageList{" +
                "total=" + total +
                ", items=" + items +
                '}';
    }
}
