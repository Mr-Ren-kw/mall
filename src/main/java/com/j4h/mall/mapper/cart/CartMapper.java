package com.j4h.mall.mapper.cart;

import com.j4h.mall.model.wx.cart.AddCart;
import com.j4h.mall.model.wx.cart.Cart;
import com.j4h.mall.model.wx.cart.CheckedTotalPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {


    int addCart(@Param("cart") Cart addCart);

    // 通过userId查询用户选中的所有商品价格和数量
    List<CheckedTotalPrice> queryCheckedTotalPriceByUserIdForWx(@Param("userId") int userId);
    // 通过cartId查询该条目的商品数量和价格
    CheckedTotalPrice queryCheckedTotalPriceByCartId(@Param("cartId") int cartId);
}
