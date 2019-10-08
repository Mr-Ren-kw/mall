package com.j4h.mall.mapper.goods;

import com.j4h.mall.model.goods.*;
import com.j4h.mall.model.wx.goods.WxGoodsCount;
import com.j4h.mall.model.wx.user.GoodsList;
import org.apache.ibatis.annotations.Param;

import java.util.List;



public interface GoodsMapper {
    List<Goods> getGoodsInfo(@Param("goodsSn") Integer goodsSn, @Param("name") String name);

    void insertGoods(@Param("goods") Goods goods);

    void insertGoodsSpecifications(@Param("goodsId") int id, @Param("specifications") List<GoodsSpecification> specifications);

    void insertGoodsProducts(@Param("goodsId") int id, @Param("products") List<GoodsProduct> products);

    void insertGoodsAttributes(@Param("goodsId") int id, @Param("attributes") List<GoodsAttribute> attributes);

    List<Category> getAllCategory();

    List<Brand> getAllBrand();

    //数据库里的gallery是String,但是返回给前端的是array
    Goods getGoodsById(@Param("id") int id);

    List<GoodsSpecification> getGoodsSpecificationByGid(@Param("gid") int id);

    List<GoodsProduct> getGoodsProductByGid(@Param("gid") int id);

    List<GoodsAttribute> getGoodsAttributeByGid(@Param("gid") int id);

    Integer getChildCategoryIdByGid(@Param("gid") int id);

    Integer getFatherCategoryIdByGid(@Param("cid") int id);

    void updateGoods(@Param("goods") Goods goods);

    void deleteGoodsSpecifications(@Param("gid") int id);

    void deleteGoodsProducts(@Param("gid") int id);

    void deleteGoodsAttributes(@Param("gid") int id);

    void deleteGoods(@Param("id") int id);

    List<GoodsComment> getGoodsComments(@Param("uid") Integer userId, @Param("gid") Integer valueId);

    void deleteCommentById(@Param("cid") int id);

    List<Goods> getGoodsByName(@Param("name") String name);

    List<Goods> getGoodsByNameExceptId(@Param("name") String name, @Param("id") int id);

    List<Goods> queryHotGoods();

    List<Goods> queryNewGoods();

    List<Goods> queryGoodsByL1Id(@Param("id") int l1Id);

    WxGoodsCount queryGoodsCountForWx();

    List<Goods> queryGoodsByCondition(@Param("cId") Integer categoryId, @Param("bId") Integer brandId, @Param("isHot") boolean isHot, @Param("isNew") boolean isNew);

    List<GoodsComment> queryGoodsComment(@Param("vId") int goodsId);

    GoodsProduct getGoodsProductByPid(@Param("pid") int productId);

    List<GoodsList> queryGoodsByOrderId(@Param("id") int id);

    String queryPicUrlById(@Param("id")int id);

    int updateGoodsNumberByGoodsIdWx(@Param("id") int productId,@Param("number")int number);

    int queryGoodsNumberByProductId(@Param("productId") int productId);
}
