package com.j4h.mall.model.wx.collect;

import java.util.List;

public class CollectPageBean {

    private List<CollectInfo> collectList;
    private long totalPages;

    public List<CollectInfo> getCollectList() {
        return collectList;
    }

    public void setCollectList(List<CollectInfo> collectList) {
        this.collectList = collectList;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }
}
