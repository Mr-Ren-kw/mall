package com.j4h.mall.service.wx.coupon;

import com.j4h.mall.model.extension.coupon.BeanForDatabase.Coupon;
import com.j4h.mall.model.wx.coupon.WxCouponList;

import java.util.List;

public interface WxCouponService {
    WxCouponList queryCouponList(int page,int size);

    WxCouponList queryUserCouponList(int page, int size, int userId, int status);

    int receiveCoupon(int userId, int couponId);

    int exchangeCoupon(int userId, String code);

    List<Coupon> queryCouponCanUse(int userId, int cartId, int grouponRulesId);
}
