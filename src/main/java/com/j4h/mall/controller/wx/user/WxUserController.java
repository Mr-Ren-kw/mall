package com.j4h.mall.controller.wx.user;

import com.j4h.mall.model.wx.user.UserOrder;
import com.j4h.mall.model.wx.user.UserOrderDetail;

import com.j4h.mall.service.wx.user.WxUserSerivce;
import com.j4h.mall.util.LoginOrNotUtils;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WxUserController {

    @Autowired
    WxUserSerivce wxUserService;
    /**
     * 用户登录以后的展示我的订单信息,如已收货,未发货
     * @return
     */
    @RequestMapping("wx/user/index")
    public BaseRespVo userIndex(){
        boolean login = LoginOrNotUtils.isLogin();
        if (!login){
            return null;
        }
        UserOrderDetail userOrderDetail=wxUserService.queryUserAllOrder();
        UserOrder userOrder = new UserOrder();
        userOrder.setOrder(userOrderDetail);
        BaseRespVo<UserOrder> ok = BaseRespVo.ok(userOrder);
        return ok;
    }


}
