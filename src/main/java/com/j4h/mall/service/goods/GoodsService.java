package com.j4h.mall.service.goods;

import com.j4h.mall.model.PageBean;
import com.j4h.mall.model.goods.GoodsComment;
import com.j4h.mall.vo.goods.CatAndBrandVo;
import com.j4h.mall.vo.goods.GoodsItemVo;

public interface GoodsService {
    PageBean getGoodsInfo(int page, int limit, String sort, String order, Integer goodsSn, String name);

    void createGoods(GoodsItemVo goodsItemVo);

    CatAndBrandVo getAllCatAndBrand();

    GoodsItemVo getGoodsDetail(int id);

    void updateGoods(GoodsItemVo goodsItemVo);

    void deleteGoods(int id);

    PageBean<GoodsComment> getAllGoodsComment(int page, int limit, String sort, String order, Integer userId, Integer valueId);

    void deleteComment(int id);
}
