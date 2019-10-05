package com.j4h.mall.model.wx.catalog;

import java.util.List;

public class WxCategoryIndex {
    private List<WxCategory> categoryList;
    private WxCategory currentCategory;
    private List<WxCategory> currentSubCategory;

    public List<WxCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<WxCategory> categoryList) {
        this.categoryList = categoryList;
    }

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
