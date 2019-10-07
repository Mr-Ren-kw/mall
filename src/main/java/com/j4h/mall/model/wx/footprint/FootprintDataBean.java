package com.j4h.mall.model.wx.footprint;

import java.util.List;

public class FootprintDataBean {

    List<FootprintList> footprintList;
    Long totalPages;

    public List<FootprintList> getFootprintList() {
        return footprintList;
    }

    public void setFootprintList(List<FootprintList> footprintList) {
        this.footprintList = footprintList;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }
}
