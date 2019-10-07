package com.j4h.mall.service.wx.cart;

import com.j4h.mall.mapper.cart.CartMapper;
import com.j4h.mall.mapper.goods.GoodsMapper;
import com.j4h.mall.model.goods.Goods;
import com.j4h.mall.model.goods.GoodsProduct;
import com.j4h.mall.model.wx.cart.AddCart;
import com.j4h.mall.model.wx.cart.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxCartServiceImpl implements WxCartService {
    @Autowired
    CartMapper cartMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public int addCart(int userId, AddCart addCart) {
        GoodsProduct goodsProduct = goodsMapper.getGoodsProductByPid(addCart.getProductId());
        Goods goods = goodsMapper.getGoodsById(addCart.getGoodsId());
        if(goodsProduct == null || goods == null) {
            // id有错，直接返回-1
            return -1;
        }
        Cart cart = new Cart();
        cart.setGoodsId(addCart.getGoodsId());
        cart.setGoodsName(goods.getName());
        cart.setGoodsSn(goods.getGoodsSn());
        cart.setNumber(addCart.getNumber());
        cart.setPicUrl(goods.getPicUrl());
        cart.setPrice(goodsProduct.getPrice());
        cart.setProductId(addCart.getProductId());
        cart.setSpecifications(goodsProduct.getSpecifications());
        cart.setUserId(userId);
        return cartMapper.addCart(cart);
    }
}
