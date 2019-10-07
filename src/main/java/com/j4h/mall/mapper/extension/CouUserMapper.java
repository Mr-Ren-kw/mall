package com.j4h.mall.mapper.extension;

import com.j4h.mall.model.extension.coupon.BeanForDatabase.CouponUser;
import com.j4h.mall.model.wx.coupon.WxMyCoupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouUserMapper {

    List<CouponUser> queryCouUserByCondition(@Param("couponId") Integer couponId, @Param("userId")Integer userId, @Param("status") Integer status);
    
    // 通过userId和status查询用户的优惠劵
    List<WxMyCoupon> queryCouUserByUserIdAndStatus(@Param("userId") int userId,@Param("status") int status);

}
