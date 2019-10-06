package com.j4h.mall.service.wx.coupon;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.extension.CouUserMapper;
import com.j4h.mall.mapper.extension.CouponMapper;
import com.j4h.mall.model.wx.coupon.WxCoupon;
import com.j4h.mall.model.wx.coupon.WxCouponList;
import com.j4h.mall.model.wx.coupon.WxMyCoupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxCouponServiceImpl implements WxCouponService {

    @Autowired
    CouponMapper couponMapper;

    @Autowired
    CouUserMapper couUserMapper;

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

    @Override
    public WxCouponList queryUserCouponList(int page, int size, int userId, int status) {
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
}
