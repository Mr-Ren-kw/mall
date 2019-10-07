package com.j4h.mall.controller.wx.coupon;

import com.j4h.mall.service.wx.coupon.WxCouponService;
import com.j4h.mall.util.LoginOrNotUtils;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.wx.coupon.WxCouponVo;
import com.j4h.mall.vo.wx.coupon.WxExchangeCouVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/receive")
    public BaseRespVo receiveCoupon(@RequestBody WxCouponVo wxCouponVo) {
        Integer userId = LoginOrNotUtils.getUserId();
        if (userId == null) {
            return BaseRespVo.fail(501, "请登录后再访问！");
        }
        // 自定义返回的状态码，0表示成功，1表示已经领取过，2表示已经领完
        int resultCode = wxCouponService.receiveCoupon(userId,wxCouponVo.getCouponId());
        if (resultCode == 0) {
            return BaseRespVo.ok(null);
        } else if (resultCode == 1) {
            return BaseRespVo.fail(740, "该券已经领过");
        } else if (resultCode == 2) {
            return BaseRespVo.fail(740, "优惠券已领完");
        } else if (resultCode == 4){
            return BaseRespVo.fail(740, "不能直接领取");
        } else {
            return BaseRespVo.fail(402, "参数错误，领取失败");
        }
    }

    @PostMapping("/exchange")
    public BaseRespVo exchangeCoupon(@RequestBody WxExchangeCouVo wxExchangeCouVo) {
        Integer userId = LoginOrNotUtils.getUserId();
        if (userId == null) {
            return BaseRespVo.fail(501, "请登录后再访问！");
        }
        // 根据返回的状态码，0表示成功，1表示已经领取过，2表示已经领完，3表示兑换码不正确
        int resultCode = wxCouponService.exchangeCoupon(userId, wxExchangeCouVo.getCode());
        if (resultCode == 0) {
            return BaseRespVo.ok(null);
        } else if (resultCode == 1) {
            return BaseRespVo.fail(742, "您已经领取过");
        } else if (resultCode == 2) {
            return BaseRespVo.fail(742, "该券已兑换完");
        } else if (resultCode == 3) {
            return BaseRespVo.fail(742, "兑换码不正确");
        }else {
            return BaseRespVo.fail(742, "系统错误，请稍后再试");
        }
    }
}
