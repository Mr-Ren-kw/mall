package com.j4h.mall.service.wx.catalog;

import com.j4h.mall.model.wx.catalog.WxCategoryIndex;
import com.j4h.mall.model.wx.catalog.WxCurrentCategory;

public interface WxCatalogService {

    WxCategoryIndex getCatalogIndex();

    WxCurrentCategory getCurrentCategory(int id);
}
