package com.j4h.mall.service.wx.cart;

import com.j4h.mall.model.wx.cart.AddCart;
import com.j4h.mall.model.wx.cart.CheckedCart;
import com.j4h.mall.model.wx.cart.IndexCart;

public interface WxCartService {
    int addCart(int userId, AddCart addCart);

    IndexCart getCartInfo(Integer userId);

    void checkedProducts(Integer userId, CheckedCart checkedCart);

    Integer getAllCartGoodsCount(Integer userId);

}
