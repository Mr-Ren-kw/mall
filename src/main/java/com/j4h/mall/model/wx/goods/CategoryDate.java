package com.j4h.mall.model.wx.goods;

import com.j4h.mall.model.mall.category.CategoryInfo;
import com.j4h.mall.model.wx.catalog.WxCategory;

import java.util.List;

public class CategoryDate {
    private List<WxCategory> brotherCategory;
    private WxCategory currentCategory;
    private WxCategory parentCategory;

    public List<WxCategory> getBrotherCategory() {
        return brotherCategory;
    }

    public void setBrotherCategory(List<WxCategory> brotherCategory) {
        this.brotherCategory = brotherCategory;
    }

    public WxCategory getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(WxCategory currentCategory) {
        this.currentCategory = currentCategory;
    }

    public WxCategory getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(WxCategory parentCategory) {
        this.parentCategory = parentCategory;
    }
}
