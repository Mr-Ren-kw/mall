package com.j4h.mall.mapper.goods;

import com.j4h.mall.model.goods.Category;
import com.j4h.mall.model.goods.GoodItem;
import com.j4h.mall.vo.goods.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    List<GoodItem> getGoodsInfo(@Param("goodsSn") Integer goodsSn, @Param("name") String name);

    void insertGoods(@Param("goods") GoodsVo goods);

    void insertGoodsSpecifications(@Param("goodsId") int id, @Param("specifications") List<GoodsSpecificationVo> specifications);

    void insertGoodsProducts(@Param("goodsId") int id, @Param("products") List<GoodsProductVo> products);

    void insertGoodsAttributes(@Param("goodsId") int id, @Param("attributes") List<GoodsAttributeVo> attributes);

    List<Category> getAllCategory();

    List<Brand> getAllBrand();

}
