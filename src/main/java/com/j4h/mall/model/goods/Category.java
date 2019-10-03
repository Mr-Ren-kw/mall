package com.j4h.mall.model.goods;

import java.util.List;



public class Category {
    private int value;
    private String label;
    private List<ChildCategory> children;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ChildCategory> getChildren() {
        return children;
    }

    public void setChildren(List<ChildCategory> children) {
        this.children = children;
    }
}
