package com.j4h.mall.vo.goods;

import java.util.List;

public class GoodsItemVo {
    private GoodsVo goods;
    private List<GoodsSpecificationVo> specifications;
    private List<GoodsProductVo> products;
    private List<GoodsAttributeVo> attributes;

    public GoodsVo getGoods() {
        return goods;
    }

    public void setGoods(GoodsVo goods) {
        this.goods = goods;
    }

    public List<GoodsSpecificationVo> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<GoodsSpecificationVo> specifications) {
        this.specifications = specifications;
    }

    public List<GoodsProductVo> getProducts() {
        return products;
    }

    public void setProducts(List<GoodsProductVo> products) {
        this.products = products;
    }

    public List<GoodsAttributeVo> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<GoodsAttributeVo> attributes) {
        this.attributes = attributes;
    }
}
