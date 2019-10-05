package com.j4h.mall.model.wx.goods;

import com.j4h.mall.model.goods.Category;
import com.j4h.mall.model.goods.Goods;
import com.j4h.mall.model.mall.category.CategoryInfo;

import java.util.List;

public class GoodsListData {
    private int count;
    private List<CategoryInfo> filterCategoryList;
    private List<Goods> goodsList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<CategoryInfo> getFilterCategoryList() {
        return filterCategoryList;
    }

    public void setFilterCategoryList(List<CategoryInfo> filterCategoryList) {
        this.filterCategoryList = filterCategoryList;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
