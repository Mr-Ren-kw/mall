package com.j4h.mall.mapper.extension;

import com.j4h.mall.model.extension.coupon.BeanForDatabase.Coupon;
import com.j4h.mall.model.wx.coupon.WxCoupon;
import com.j4h.mall.model.wx.coupon.WxMyCoupon;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface CouponMapper {
    List<Coupon> queryCouponByCondition(@Param("name") String name, @Param("status") int status, @Param("type") int type);

    void insertCoupon(@Param("coupon") Coupon coupon);

    Coupon queryCouponById(@Param("id") int couponId);

    void updateCoupon(@Param("coupon") Coupon coupon);

    void deleteCouponById(@Param("id") int couponId);

    // 查询所有的优惠劵--rkw
    List<WxCoupon> queryCouponList();
    // 通过id查询并封装到传入的bean中--rkw
    WxCoupon queryCouponByIdForWx(@Param("id")int id);
    // 更新优惠券的数量
    int updateCouponCountById(@Param("id") int couponId,@Param("newTotal") int newTotal);
    // 根据兑换码查询对应的优惠券
    Coupon queryCouponByCode(@Param("code") String code);
    //
    Coupon queryCouponByIdAndMin(@Param("id") int couponId,@Param("count") double count);
}
