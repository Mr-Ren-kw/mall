package com.j4h.mall.service.wx.cart;

import com.j4h.mall.model.wx.cart.AddCart;

public interface WxCartService {
    int addCart(int userId, AddCart addCart);
}
