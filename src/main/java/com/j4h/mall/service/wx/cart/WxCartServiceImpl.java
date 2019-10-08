package com.j4h.mall.service.wx.cart;

import com.j4h.mall.mapper.address.AddressMapper;
import com.j4h.mall.mapper.cart.CartMapper;
import com.j4h.mall.mapper.configs.ConfigMapper;
import com.j4h.mall.mapper.extension.CouUserMapper;
import com.j4h.mall.mapper.extension.CouponMapper;
import com.j4h.mall.mapper.extension.GrouponRulesMapper;
import com.j4h.mall.mapper.goods.GoodsMapper;
import com.j4h.mall.model.extension.coupon.BeanForDatabase.Coupon;
import com.j4h.mall.model.goods.Goods;
import com.j4h.mall.model.goods.GoodsProduct;
import com.j4h.mall.model.wx.address.WxAddressDetail;
import com.j4h.mall.model.wx.cart.*;
import com.j4h.mall.service.wx.coupon.WxCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WxCartServiceImpl implements WxCartService {
    @Autowired
    CartMapper cartMapper;

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    CouponMapper couponMapper;
    @Autowired
    WxCouponService wxCouponService;
    @Autowired
    ConfigMapper configMapper;
    @Autowired
    GrouponRulesMapper grouponRulesMapper;
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    CouUserMapper couUserMapper;
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
                if (cart.getProductId() == addCart.getProductId() && cart.getGoodsId() == addCart.getGoodsId()) {
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

    @Override
    public CartCheckout checkout(Integer userId, int cartId, int addressId, int couponId, int grouponRulesId) {
        CartCheckout cartCheckout = new CartCheckout();
        if (grouponRulesId != 0) {
            double discountById = grouponRulesMapper.getDiscountById(grouponRulesId);
            cartCheckout.setGrouponPrice(discountById);
            cartCheckout.setGrouponRulesId(grouponRulesId);
        }
        Coupon coupon = null;
        if (couponId > 0) {
            if(couUserMapper.getCouExistsByUidCouId(userId, couponId) == 1) {
                coupon = couponMapper.queryCouponById(couponId);
                cartCheckout.setCouponId(couponId);
                cartCheckout.setCouponPrice(coupon.getDiscount());
            }
        }
        cartCheckout.setAvailableCouponLength(wxCouponService.queryCouponCanUse(userId, cartId, 0).size());
        // 这里要做addressId的校验，因为小程序缓存的原因，会把上次登陆的addressId缓存起来
        if (addressId != 0 && addressMapper.getUserIdById(addressId) == userId) {
            WxAddressDetail addressDetailById = addressMapper.getAddressDetailById(addressId);
            cartCheckout.setCheckedAddress(addressDetailById);
        }
        cartCheckout.setAddressId(addressId);
        // 0说明是从购物车那里点击的
        if (cartId == 0) {
            // 如果couponId非0, 则要去查找该优惠券的减免金额, 否则就默认的0
            List<Cart> cartList = cartMapper.getCheckedGoodsListByUid(userId);
            cartCheckout.setCheckedGoodsList(cartList);
        }
        // 否则是点击商品直接购买的
        else {
            Cart cart = cartMapper.getCheckedGoodsById(cartId);
            List<Cart> cartList = new ArrayList<>();
            cartList.add(cart);
            cartCheckout.setCheckedGoodsList(cartList);
        }
        String mallSystemExpressFreightMin = configMapper.getMallSystemExpressFreightMin();
        String mallSystemExpressFreightValue = configMapper.getMallSystemExpressFreightValue();
        // 默认满88才免运费, 运费8元
        int freightMin = 88;
        int freightValue = 8;
        try {
            freightMin = Integer.parseInt(mallSystemExpressFreightMin);
            freightValue = Integer.parseInt(mallSystemExpressFreightValue);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        List<Cart> checkedGoodsList = cartCheckout.getCheckedGoodsList();
        if (checkedGoodsList != null && checkedGoodsList.size() != 0) {
            for (Cart cart : checkedGoodsList) {
                cartCheckout.setGoodsTotalPrice(cartCheckout.getGoodsTotalPrice() + cart.getNumber() * cart.getPrice());
            }
        }
        if (coupon != null && coupon.getMin() > cartCheckout.getGoodsTotalPrice()) {
            cartCheckout.setCouponId(0);
            cartCheckout.setCouponPrice(0);
        }
        if (cartCheckout.getGoodsTotalPrice() < freightMin) {
            // 如果小于最小的运费要求，才设置
            cartCheckout.setFreightPrice(freightValue);
        }
        cartCheckout.setOrderTotalPrice(cartCheckout.getGoodsTotalPrice() + cartCheckout.getFreightPrice() - cartCheckout.getCouponPrice());
        // 这里本应该再减去积分减免的钱的，但是我没做
        cartCheckout.setActualPrice(cartCheckout.getOrderTotalPrice());
        return cartCheckout;
    }

}
