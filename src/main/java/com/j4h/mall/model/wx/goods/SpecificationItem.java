package com.j4h.mall.model.wx.goods;

import com.j4h.mall.model.goods.GoodsSpecification;

import java.util.List;

public class SpecificationItem {
    private String name;
    private List<GoodsSpecification> valueList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GoodsSpecification> getValueList() {
        return valueList;
    }

    public void setValueList(List<GoodsSpecification> valueList) {
        this.valueList = valueList;
    }
}
