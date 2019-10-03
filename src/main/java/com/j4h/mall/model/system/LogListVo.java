package com.j4h.mall.model.system;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/3 23:27
 */
public class LogListVo {
    private long total;
    private List<LogVo> items;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<LogVo> getItems() {
        return items;
    }

    public void setItems(List<LogVo> items) {
        this.items = items;
    }
}
