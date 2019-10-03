package com.j4h.mall.model.system;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/3 17:39
 */
public class RoleList {
    private long total;
    private List<Role> items;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Role> getItems() {
        return items;
    }

    public void setItems(List<Role> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "RoleList{" +
                "total=" + total +
                ", items=" + items +
                '}';
    }
}
