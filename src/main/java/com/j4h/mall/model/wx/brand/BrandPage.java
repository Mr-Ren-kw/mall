package com.j4h.mall.model.wx.brand;

import com.j4h.mall.model.mall.brand.Brand;

import java.util.List;

public class BrandPage {
    private int totalPages;
    private List<Brand> brandList;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }
}
