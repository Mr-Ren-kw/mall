package com.j4h.mall.service.wx.goods;

import com.j4h.mall.model.goods.GoodsList;
import com.j4h.mall.model.wx.goods.CategoryDate;
import com.j4h.mall.model.wx.goods.GoodsDetail;
import com.j4h.mall.model.wx.goods.GoodsListData;
import com.j4h.mall.model.wx.goods.WxGoodsCount;
import com.j4h.mall.vo.goods.BeanForGoodsPage;

public interface WxGoodsService {
    WxGoodsCount queryGoodsCountForWx();

    GoodsListData queryGoodsList(BeanForGoodsPage beanForGoodsPage);

    CategoryDate queryCategory(int categoryId);

    GoodsDetail queryGoodsDetail(int goodsId);

    GoodsList queryRelatedGoods(int goodsId);
}
