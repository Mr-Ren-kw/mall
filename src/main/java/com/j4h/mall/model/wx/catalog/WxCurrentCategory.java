package com.j4h.mall.model.wx.catalog;

import java.util.List;

public class WxCurrentCategory {
    private WxCategory currentCategory;
    private List<WxCategory> currentSubCategory;

    public WxCategory getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(WxCategory currentCategory) {
        this.currentCategory = currentCategory;
    }

    public List<WxCategory> getCurrentSubCategory() {
        return currentSubCategory;
    }

    public void setCurrentSubCategory(List<WxCategory> currentSubCategory) {
        this.currentSubCategory = currentSubCategory;
    }
}
