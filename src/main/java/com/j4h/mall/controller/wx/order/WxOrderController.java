package com.j4h.mall.controller.wx.order;

import com.j4h.mall.model.wx.order.OrderSubmit;
import com.j4h.mall.model.wx.user.AllGoodsList;
import com.j4h.mall.model.wx.order.ResultOrder;
import com.j4h.mall.service.wx.order.WxUserOrderService;
import com.j4h.mall.util.LoginOrNotUtils;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.wx.order.OrderId;
import com.j4h.mall.vo.wx.order.SubmitOrder;
import com.j4h.mall.vo.wx.user.UserOrderPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WxOrderController {
    @Autowired
    WxUserOrderService wxUserOrderService;

    @RequestMapping("wx/order/list")
    public BaseRespVo orderList(UserOrderPage userOrderPage) {
        boolean login = LoginOrNotUtils.isLogin();
        if (!login) {
            return BaseRespVo.fail(501,"请登录后再访问");
        }
        AllGoodsList allGoodsList = wxUserOrderService.queryAllOrderList(userOrderPage);
        BaseRespVo<AllGoodsList> ok = BaseRespVo.ok(allGoodsList);
        return ok;
    }

    @RequestMapping("wx/order/detail")
    public BaseRespVo orderDetail(int orderId) {
        if (!LoginOrNotUtils.isLogin()) {
            return BaseRespVo.fail(501, "请登录后再访问");
        }
        ResultOrder order = wxUserOrderService.querySingleOrderByOrderId(orderId);
        BaseRespVo<ResultOrder> ok = BaseRespVo.ok(order);
        return ok;
    }

    //付款
    @RequestMapping("wx/order/prepay")
    public BaseRespVo orderPrepay(@RequestBody OrderId orderId) {
        if (!LoginOrNotUtils.isLogin()) {
            return BaseRespVo.fail(501, "请登录后再访问");
        }
        int orderId1;
        try {
            orderId1 = Integer.parseInt(orderId.getOrderId());
        } catch (NumberFormatException e) {
            return BaseRespVo.fail(402, "参数异常，付款失败");
        }
        boolean flag = wxUserOrderService.orderPrepay(orderId1);
        if (flag) {
            return BaseRespVo.ok("付款成功");
        }
        return null;

    }

    @RequestMapping("wx/order/cancel")
    public BaseRespVo orderCancel(@RequestBody OrderId orderId) {
        if (!LoginOrNotUtils.isLogin()) {
            return BaseRespVo.fail(501, "请登录后再访问");
        }
        int orderId1;
        try {
            orderId1 = Integer.parseInt(orderId.getOrderId());
        } catch (NumberFormatException e) {
            return BaseRespVo.fail(402, "参数异常，付款失败");
        }
        boolean flag = wxUserOrderService.orderCancel(orderId1);
        if (flag) {
            return BaseRespVo.ok(null);
        }
        return null;
    }

    @RequestMapping("wx/order/confirm")
    public BaseRespVo orderConfirm(@RequestBody OrderId orderId) {
        if (!LoginOrNotUtils.isLogin()) {
            return BaseRespVo.fail(501, "请登录后再访问");
        }
        int orderId1;
        try {
            orderId1 = Integer.parseInt(orderId.getOrderId());
        } catch (NumberFormatException e) {
            return BaseRespVo.fail(402, "参数异常，付款失败");
        }
        boolean flag = wxUserOrderService.orderConfirm(orderId1);
        if (flag) {
            return BaseRespVo.ok(null);
        }
        return null;
    }

    @RequestMapping("wx/order/delete")
    public BaseRespVo orderDelete(@RequestBody OrderId orderId){
        Integer userId = LoginOrNotUtils.getUserId();
        if (userId == null) {
            return BaseRespVo.fail(501, "请登录后再访问");
        }
        int orderId2;
        try {
            orderId2 = Integer.parseInt(orderId.getOrderId());
        } catch (NumberFormatException e) {
            return BaseRespVo.fail(402, "参数异常，付款失败");
        }
        return wxUserOrderService.orderDeleteByOid(orderId2) ? BaseRespVo.ok(null) : BaseRespVo.fail();
    }

    @RequestMapping("wx/order/refund")
    public BaseRespVo orderRefund(@RequestBody OrderId orderId){
        Integer userId = LoginOrNotUtils.getUserId();
        if (userId == null) {
            return BaseRespVo.fail(501, "请登录后再访问");
        }
        int orderId3;
        try {
            orderId3 = Integer.parseInt(orderId.getOrderId());
        } catch (NumberFormatException e) {
            return BaseRespVo.fail(402, "参数异常，付款失败");
        }
        boolean flag = wxUserOrderService.orderRefund(orderId3);
        if (flag){
            return BaseRespVo.ok(null);
        }
        return null;
    }

    @RequestMapping("wx/order/submit")
    public BaseRespVo orderSubmit(@RequestBody SubmitOrder submitOrder) throws Exception {
        Integer userId = LoginOrNotUtils.getUserId();
        if (userId == null) {
            return BaseRespVo.fail(501, "请登录后再访问");
        }
        OrderSubmit order = wxUserOrderService.orderSubmit(submitOrder,userId);

        if (order.getOrderId()==0){
            return BaseRespVo.fail(402,"参数错误");
        }
       return BaseRespVo.ok(order);
    }
}
