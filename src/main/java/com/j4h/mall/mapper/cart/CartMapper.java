package com.j4h.mall.mapper.cart;

import com.j4h.mall.model.wx.cart.Cart;
import com.j4h.mall.model.wx.cart.CheckedCart;
import com.j4h.mall.model.wx.cart.CheckedTotalPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {


    int addCart(@Param("cart") Cart addCart);



    List<Cart> getCartListByUid(@Param("uid") Integer userId);

    int updateProductCheckedByUidAndPid(@Param("uid") Integer userId, @Param("checkedCart") CheckedCart checkedCart);

    int updateCartNumberById(@Param("id") int id, @Param("uid") int userId, @Param("number") int number);

    int getTotalNumber(@Param("uid") int userId);

    void deleteCartByUidPid(@Param("uid") Integer userId, @Param("pids") int[] productId);

    void addAnonCart(@Param("cart") Cart cart);

    // 通过userId查询用户选中的所有商品价格和数量
    List<CheckedTotalPrice> queryCheckedTotalPriceByUserIdForWx(@Param("userId") int userId);
    // 通过cartId查询该条目的商品数量和价格
    CheckedTotalPrice queryCheckedTotalPriceByCartId(@Param("cartId") int cartId);

    List<Cart> queryCartByCidAndUserId(@Param("cartId") int cartId,@Param("userId") int userId);

    int updateDeletedByCidAndUserId(@Param("cartId") int cartId,@Param("userId") int userId);
}
