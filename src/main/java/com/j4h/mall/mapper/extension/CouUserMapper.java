package com.j4h.mall.mapper.extension;

import com.j4h.mall.model.extension.coupon.BeanForDatabase.CouponUser;
import com.j4h.mall.model.wx.coupon.WxMyCouChangeStatus;
import com.j4h.mall.model.wx.coupon.WxMyCoupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouUserMapper {

    List<CouponUser> queryCouUserByCondition(@Param("couponId") int couponId, @Param("userId")int userId, @Param("status") int status);

    // 通过userId和status查询用户的优惠劵
    List<WxMyCoupon> queryCouUserByUserIdAndStatus(@Param("userId") int userId,@Param("status") int status);

    // 通过userId和couponId查询该用户拥有的该优惠券数量
    int queryCouCountByUserIdAndCouId(@Param("userId") int userId,@Param("couponId") int couponId);
    // 为用户新增优惠券
    int addCouponForUser(@Param("userId") int userId,@Param("couponId") int couponId,@Param("start") String startTime,@Param("end") String endTime);
    // 查询用户未使用的优惠劵，看是否重复
    List<WxMyCouChangeStatus> queryCouUserForCheckStatus(@Param("userId") int userId);
    // 将用户过期的优惠券状态码同步
    int updateCouUserStatusToLater(@Param("id") int id);


    int getCouExistsByUidCouId(@Param("uid") Integer userId, @Param("cid") int couponId);

    int updateCouponStatusByCouponId(@Param("couponId") int couponId,
                                     @Param("orderId")int orderId,
                                     @Param("userId")int userId);

}
