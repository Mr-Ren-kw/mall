package com.j4h.mall.vo.goods;

import com.j4h.mall.model.goods.Category;
import org.springframework.context.annotation.Bean;

import java.util.List;


public class CatAndBrandVo {
    private List<Category> categoryList;
    private List<Brand> brandList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }
}
