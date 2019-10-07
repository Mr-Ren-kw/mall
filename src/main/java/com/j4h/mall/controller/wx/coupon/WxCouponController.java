package com.j4h.mall.controller.wx.coupon;

import com.j4h.mall.service.wx.coupon.WxCouponService;
import com.j4h.mall.util.LoginOrNotUtils;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/coupon")
public class WxCouponController {

    @Autowired
    WxCouponService wxCouponService;

    @GetMapping("/list")
    public BaseRespVo getCouponList(int page,int size) {
        return BaseRespVo.ok(wxCouponService.queryCouponList(page,size));
    }

    @GetMapping("/mylist")
    public BaseRespVo getUserCouponList(int status, int page, int size) {
        // 判断用户是否登录
        Integer userId = LoginOrNotUtils.getUserId();
        if (userId == null) {
            return BaseRespVo.fail(501, "请登录后再访问！");
        }
        return BaseRespVo.ok(wxCouponService.queryUserCouponList(page, size, userId, status));
    }

}
