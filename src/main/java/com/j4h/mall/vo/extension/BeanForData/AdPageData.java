package com.j4h.mall.vo.extension.BeanForData;

import com.j4h.mall.model.extension.ad.BeanForDatabase.Advertise;
import java.util.List;

public class AdPageData {
    private int total;
    private List<Advertise> items;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Advertise> getItems() {
        return items;
    }

    public void setItems(List<Advertise> items) {
        this.items = items;
    }
}
