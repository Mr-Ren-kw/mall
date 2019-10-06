package com.j4h.mall.service.wx.coupon;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.extension.CouUserMapper;
import com.j4h.mall.mapper.extension.CouponMapper;
import com.j4h.mall.model.extension.coupon.BeanForDatabase.Coupon;
import com.j4h.mall.model.wx.coupon.WxCoupon;
import com.j4h.mall.model.wx.coupon.WxCouponList;
import com.j4h.mall.model.wx.coupon.WxMyCouChangeStatus;
import com.j4h.mall.model.wx.coupon.WxMyCoupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class WxCouponServiceImpl implements WxCouponService {

    @Autowired
    CouponMapper couponMapper;

    @Autowired
    CouUserMapper couUserMapper;

    /**
     * 查询未被删除的优惠劵信息
     * @param page
     * @param size
     * @return
     */
    @Override
    public WxCouponList queryCouponList(int page,int size) {
        PageHelper.startPage(page, size);
        List<WxCoupon> wxCoupons = couponMapper.queryCouponList();
        PageInfo<WxCoupon> wxCouponPageInfo = new PageInfo<>(wxCoupons);
        int total = (int) wxCouponPageInfo.getTotal();
        WxCouponList<WxCoupon> wxCouponList = new WxCouponList<>();
        wxCouponList.setCount(total);
        wxCouponList.setData(wxCoupons);
        return wxCouponList;
    }

    /**
     * 查询指定用户的优惠劵信息
     * @param page
     * @param size
     * @param userId
     * @param status
     * @return
     */
    @Override
    public WxCouponList queryUserCouponList(int page, int size, int userId, int status) {
        // 在查询前先将过期的优惠劵修改状态
        List<WxMyCouChangeStatus> myCouChangeStatusList = couUserMapper.queryCouUserForCheckStatus(userId);
        for (WxMyCouChangeStatus wxMyCouChangeStatus : myCouChangeStatusList) {
            if (wxMyCouChangeStatus.getEndTime().before(new Date())) {
                couUserMapper.updateCouUserStatusToLater(wxMyCouChangeStatus.getId());
            }
        }
        // 开始查询
        PageHelper.startPage(page, size);
        List<WxMyCoupon> wxMyCoupons = couUserMapper.queryCouUserByUserIdAndStatus(userId,status);
        WxCoupon wxCoupon;
        for (WxMyCoupon wxMyCoupon : wxMyCoupons) {
            wxCoupon = couponMapper.queryCouponByIdForWx(wxMyCoupon.getCouponId());
            wxMyCoupon.setDesc(wxCoupon.getDesc());
            wxMyCoupon.setDiscount(wxCoupon.getDiscount()+"");
            wxMyCoupon.setMin(wxCoupon.getMin() +"");
            wxMyCoupon.setName(wxCoupon.getName());
            wxMyCoupon.setTag(wxCoupon.getTag());
        }
        PageInfo<WxMyCoupon> wxMyCouponPageInfo = new PageInfo<>(wxMyCoupons);
        WxCouponList<WxMyCoupon> wxCouponList = new WxCouponList<>();
        wxCouponList.setCount((int) wxMyCouponPageInfo.getTotal());
        wxCouponList.setData(wxMyCoupons);
        return wxCouponList;
    }

    /**
     * 领取优惠劵
     * @param userId 用户id
     * @param couponId 优惠券id
     * @return
     */
    @Override
    public int receiveCoupon(int userId, int couponId) {
        // 首先判断该优惠劵数量是否为零
        Coupon coupon = couponMapper.queryCouponById(couponId);
        if (coupon.getTotal() <= 0) {
            return 2;
        }
        if (coupon.getLimit() == 1) {
            // 再判断该用户是否已经领取过
            int num = couUserMapper.queryCouCountByUserIdAndCouId(userId, couponId);
            if (num != 0) {
                return 1;
            }
        }
        // 领取
        int newTotal = coupon.getTotal() - 1;
        // 设置新的优惠券数量
        int result = couponMapper.updateCouponCountById(couponId, newTotal);
        if (result == 1) {
            // 给用户添加改优惠券
            String startTime;
            String endTime;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if (coupon.getTimeType() == 0) {
                int days = coupon.getDays();
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
                startTime = simpleDateFormat.format(new Date());
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DATE,days);
                endTime = simpleDateFormat2.format(calendar.getTime()) + startTime.substring(10);
            }else {
                startTime = simpleDateFormat.format(coupon.getStartTime());
                endTime = simpleDateFormat.format(coupon.getEndTime());
            }
            result = couUserMapper.addCouponForUser(userId,couponId, startTime, endTime);
        }
        return result == 1 ? 0 : 3;
    }
}
