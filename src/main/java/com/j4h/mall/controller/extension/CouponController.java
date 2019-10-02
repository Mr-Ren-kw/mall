package com.j4h.mall.controller.extension;

import com.j4h.mall.model.extension.coupon.BeanForDatabase.Coupon;
import com.j4h.mall.service.extension.coupon.CouponService;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.extension.BeanForData.PageData;
import com.j4h.mall.vo.extension.BeanForRequest.CouUserPageRequest;
import com.j4h.mall.vo.extension.BeanForRequest.CouponPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/coupon")
public class CouponController {

    @Autowired
    CouponService couponService;

    @GetMapping("/list")
    public BaseRespVo couponPage(CouponPageRequest couponPageRequest) {
        PageData couponPageData = couponService.queryCouponByPage(couponPageRequest);
        return BaseRespVo.ok(couponPageData);
    }
    @RequestMapping("/create")
    public BaseRespVo createCoupon(@RequestBody Coupon coupon) {
        Coupon coupon1 = couponService.addCoupon(coupon);
        return BaseRespVo.ok(coupon1);
    }
    @GetMapping("/read")
    public BaseRespVo couponInfo(int id) {
        Coupon coupon = couponService.queryCouponById(id);
        return BaseRespVo.ok(coupon);
    }
    @GetMapping("/listuser")
    public BaseRespVo couponUser(CouUserPageRequest couUserPageRequest) {
        PageData couUserPageData = couponService.queryCouUserByPage(couUserPageRequest);
        return BaseRespVo.ok(couUserPageData);
    }
    @RequestMapping("/update")
    public BaseRespVo updateCoupon(@RequestBody Coupon coupon) {
        Coupon coupon1 = couponService.updateCoupon(coupon);
        return BaseRespVo.ok(coupon1);
    }
    @RequestMapping("/delete")
    public BaseRespVo deleteCoupon(@RequestBody Coupon coupon) {
        couponService.deleteCoupon(coupon);
        return BaseRespVo.ok(null);
    }
}
