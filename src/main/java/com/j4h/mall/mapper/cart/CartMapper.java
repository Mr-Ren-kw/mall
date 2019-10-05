package com.j4h.mall.mapper.cart;

import com.j4h.mall.model.wx.cart.AddCart;
import com.j4h.mall.model.wx.cart.Cart;
import com.j4h.mall.model.wx.cart.CartTotal;
import com.j4h.mall.model.wx.cart.CheckedCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {


    int addCart(@Param("cart") Cart addCart);


    List<Cart> getCartListByUid(@Param("uid") Integer userId);

    int updateProductCheckedByUidAndPid(@Param("uid") Integer userId, @Param("checkedCart") CheckedCart checkedCart);


}
