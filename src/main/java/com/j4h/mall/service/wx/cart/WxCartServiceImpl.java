package com.j4h.mall.service.wx.cart;

import com.j4h.mall.mapper.cart.CartMapper;
import com.j4h.mall.mapper.goods.GoodsMapper;
import com.j4h.mall.model.goods.Goods;
import com.j4h.mall.model.goods.GoodsProduct;
import com.j4h.mall.model.wx.cart.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        if (goodsProduct == null || goods == null) {
            // id有错，直接返回-1
            return -1;
        }
        List<Cart> cartListByUid = cartMapper.getCartListByUid(userId);
        // 否则cart不为空，然后根据
        if (cartListByUid != null && cartListByUid.size() != 0) {
            for (Cart cart : cartListByUid) {
                if(cart.getProductId() == addCart.getProductId() && cart.getGoodsId() == addCart.getGoodsId()) {
                    // 说明是同一个商品，直接更新cart表里这条记录
                    cartMapper.updateCartNumberById(cart.getId(), userId, addCart.getNumber() + cart.getNumber());
                    return cartMapper.getTotalNumber(userId);
                }
            }
        }
        // 说明cart是空的或者购物车里面没有新插入的这条记录，直接插入一条数据
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

    @Override
    public IndexCart getCartInfo(Integer userId) {
        List<Cart> cartList = cartMapper.getCartListByUid(userId);
        CartTotal cartTotal = new CartTotal();
        if (cartList != null && cartList.size() != 0) {
            for (Cart cart : cartList) {
                if (cart != null) {
                    if (cart.getChecked()) {
                        cartTotal.setCheckedGoodsCount(cartTotal.getCheckedGoodsCount() + cart.getNumber());
                        cartTotal.setCheckedGoodsAmount(cartTotal.getCheckedGoodsAmount() + cart.getNumber() * cart.getPrice());
                    }
                    cartTotal.setGoodsCount(cartTotal.getGoodsCount() + cart.getNumber());
                    cartTotal.setGoodsAmount(cartTotal.getGoodsAmount() + cart.getNumber() * cart.getPrice());
                }
            }
        }
        return new IndexCart(cartList, cartTotal);
    }

    @Override
    public void checkedProducts(Integer userId, CheckedCart checkedCart) {
        cartMapper.updateProductCheckedByUidAndPid(userId, checkedCart);
    }

    @Override
    public Integer getAllCartGoodsCount(Integer userId) {
        List<Cart> cartListByUid = cartMapper.getCartListByUid(userId);
        if (cartListByUid == null || cartListByUid.size() == 0) {
            return 0;
        }
        Integer cnt = 0;
        for (Cart cart : cartListByUid) {
            cnt += cart.getNumber();
        }
        return cnt;
    }

    @Override
    public void updateCartProduct(Integer userId, AddCart addCart) {
        cartMapper.updateCartNumberById(addCart.getId(), userId, addCart.getNumber());
    }

    @Override
    public void deleteCart(Integer userId, int[] productId) {
        cartMapper.deleteCartByUidPid(userId, productId);
    }

    @Override
    public int addAnonCart(Integer userId, AddCart addCart) {
        GoodsProduct goodsProduct = goodsMapper.getGoodsProductByPid(addCart.getProductId());
        Goods goods = goodsMapper.getGoodsById(addCart.getGoodsId());
        if (goodsProduct == null || goods == null) {
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
        cartMapper.addAnonCart(cart);
        return cart.getId();
    }


}
