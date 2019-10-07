package com.j4h.mall.model.wx.cart;

import java.util.List;

public class IndexCart {
    private List<Cart> cartList;
    private CartTotal cartTotal;

    public IndexCart(List<Cart> cartList, CartTotal cartTotal) {
        this.cartList = cartList;
        this.cartTotal = cartTotal;
    }

    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
    }

    public CartTotal getCartTotal() {
        return cartTotal;
    }

    public void setCartTotal(CartTotal cartTotal) {
        this.cartTotal = cartTotal;
    }
}
