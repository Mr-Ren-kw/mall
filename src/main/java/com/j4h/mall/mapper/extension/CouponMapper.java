package com.j4h.mall.mapper.extension;

import com.j4h.mall.model.extension.coupon.BeanForDatabase.Coupon;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface CouponMapper {
    List<Coupon> queryCouponByCondition(@Param("name") String name, @Param("status") Integer status, @Param("type") Integer type);

    void insertCoupon(@Param("coupon") Coupon coupon);

    Coupon queryCouponById(@Param("id") int couponId);

    void updateCoupon(@Param("coupon") Coupon coupon);

    void deleteCouponById(@Param("id") int couponId);
}
