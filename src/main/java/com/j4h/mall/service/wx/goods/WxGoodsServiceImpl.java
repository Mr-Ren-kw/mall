package com.j4h.mall.service.wx.goods;

import com.j4h.mall.mapper.goods.GoodsMapper;
import com.j4h.mall.model.wx.goods.WxGoodsCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxGoodsServiceImpl implements WxGoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public WxGoodsCount queryGoodsCountForWx() {
        return goodsMapper.queryGoodsCountForWx();
    }
}
