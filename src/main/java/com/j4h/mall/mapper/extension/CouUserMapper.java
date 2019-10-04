package com.j4h.mall.mapper.extension;

import com.j4h.mall.model.extension.coupon.BeanForDatabase.CouponUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouUserMapper {
    List<CouponUser> queryCouUserByCondition(@Param("couponId") int couponId, @Param("userId")int userId, @Param("status") int status);
}
