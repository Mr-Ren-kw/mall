package com.j4h.mall.service.wx.brand;

import com.j4h.mall.model.wx.brand.BrandInfo;
import com.j4h.mall.model.wx.brand.BrandPage;

public interface WxBrandService {
    BrandPage queryBrandByPage(int page, int size, Integer brandId);

    BrandInfo queryBrandById(int brandId);
}
