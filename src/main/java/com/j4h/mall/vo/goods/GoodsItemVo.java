package com.j4h.mall.vo.goods;

import com.j4h.mall.model.goods.Goods;
import com.j4h.mall.model.goods.GoodsAttribute;
import com.j4h.mall.model.goods.GoodsProduct;
import com.j4h.mall.model.goods.GoodsSpecification;

import java.util.List;

public class GoodsItemVo {
    private Goods goods;
    private List<GoodsSpecification> specifications;
    private List<GoodsProduct> products;
    private List<GoodsAttribute> attributes;
    private List<Integer> categoryIds;

    public List<Integer> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<GoodsSpecification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<GoodsSpecification> specifications) {
        this.specifications = specifications;
    }

    public List<GoodsProduct> getProducts() {
        return products;
    }

    public void setProducts(List<GoodsProduct> products) {
        this.products = products;
    }

    public List<GoodsAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<GoodsAttribute> attributes) {
        this.attributes = attributes;
    }

}
