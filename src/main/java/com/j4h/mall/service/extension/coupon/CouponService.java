package com.j4h.mall.service.extension.coupon;

import com.j4h.mall.model.extension.coupon.BeanForDatabase.Coupon;
import com.j4h.mall.vo.extension.BeanForData.PageData;
import com.j4h.mall.vo.extension.BeanForRequest.CouUserPageRequest;
import com.j4h.mall.vo.extension.BeanForRequest.CouponPageRequest;

public interface CouponService {
    PageData queryCouponByPage(CouponPageRequest couponPageRequest);

    Coupon addCoupon(Coupon coupon);

    Coupon queryCouponById(int id);

    PageData queryCouUserByPage(CouUserPageRequest couUserPageRequest);

    Coupon updateCoupon(Coupon coupon);

    void deleteCoupon(Coupon coupon);
}
