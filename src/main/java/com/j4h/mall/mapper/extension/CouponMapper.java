package com.j4h.mall.mapper.extension;

import com.j4h.mall.model.extension.coupon.BeanForDatabase.Coupon;
import com.j4h.mall.model.wx.coupon.WxCoupon;
import com.j4h.mall.model.wx.coupon.WxMyCoupon;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface CouponMapper {
    List<Coupon> queryCouponByCondition(@Param("name") String name, @Param("status") Integer status, @Param("type") Integer type);

    void insertCoupon(@Param("coupon") Coupon coupon);

    Coupon queryCouponById(@Param("id") int couponId);

    void updateCoupon(@Param("coupon") Coupon coupon);

    void deleteCouponById(@Param("id") int couponId);

    // 查询所有的优惠劵--rkw
    List<WxCoupon> queryCouponList();
    // 通过id查询并封装到传入的bean中--rkw
    WxCoupon queryCouponByIdForWx(@Param("id")int id);
}
