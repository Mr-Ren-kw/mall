package com.j4h.mall.service.wx.coupon;

import com.j4h.mall.model.wx.coupon.WxCouponList;

public interface WxCouponService {
    WxCouponList queryCouponList(int page,int size);

    WxCouponList queryUserCouponList(int page, int size, int userId, int status);

    int receiveCoupon(int userId, int couponId);

    int exchangeCoupon(int userId, String code);
}
