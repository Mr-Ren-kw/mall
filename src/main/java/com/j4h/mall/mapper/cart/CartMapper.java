package com.j4h.mall.mapper.cart;

import com.j4h.mall.model.wx.cart.AddCart;
import com.j4h.mall.model.wx.cart.Cart;
import org.apache.ibatis.annotations.Param;

public interface CartMapper {


    int addCart(@Param("cart") Cart addCart);


}
