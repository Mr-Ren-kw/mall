package com.j4h.mall.service.wx.catalog;

import com.j4h.mall.mapper.mall.CategoryMapper;
import com.j4h.mall.model.wx.catalog.WxCategory;
import com.j4h.mall.model.wx.catalog.WxCategoryIndex;
import com.j4h.mall.model.wx.catalog.WxCurrentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxCatalogServiceImpl implements WxCatalogService {

    @Autowired
    CategoryMapper categoryMapper;


    @Override
    public WxCategoryIndex getCatalogIndex() {
        WxCategoryIndex wxCategoryIndex = new WxCategoryIndex();
        // 先查询所有的一级目录
        List<WxCategory> categoryList = categoryMapper.queryCategoryListForWxIndex(0);
        wxCategoryIndex.setCategoryList(categoryList);
        // 再查询第一个一级目录对应的二级目录
        int id = 0;
        if (categoryList.get(0) != null) {
            id = categoryList.get(0).getId();
            wxCategoryIndex.setCurrentCategory(categoryList.get(0));
        }
        wxCategoryIndex.setCurrentSubCategory(categoryMapper.queryCategoryListForWxIndex(id));
        return wxCategoryIndex;
    }

    @Override
    public WxCurrentCategory getCurrentCategory(int id) {
        WxCurrentCategory wxCurrentCategory = new WxCurrentCategory();
        wxCurrentCategory.setCurrentCategory(categoryMapper.queryCurrentCategoryForWx(id));
        wxCurrentCategory.setCurrentSubCategory(categoryMapper.queryCategoryListForWxIndex(id));
        return wxCurrentCategory;
    }
}
