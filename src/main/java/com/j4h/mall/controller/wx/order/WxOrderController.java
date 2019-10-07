package com.j4h.mall.controller.wx.order;

import com.j4h.mall.model.wx.user.AllGoodsList;
import com.j4h.mall.model.wx.order.ResultOrder;
import com.j4h.mall.service.wx.order.WxUserOrderService;
import com.j4h.mall.util.LoginOrNotUtils;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.wx.order.OrderId;
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
            return null;
        }
        AllGoodsList allGoodsList = wxUserOrderService.queryAllOrderList(userOrderPage);
        BaseRespVo<AllGoodsList> ok = BaseRespVo.ok(allGoodsList);
        return ok;
    }

    @RequestMapping("wx/order/detail")
    public BaseRespVo orderDetail(int orderId) {
        ResultOrder order = wxUserOrderService.querySingleOrderByOrderId(orderId);
        BaseRespVo<ResultOrder> ok = BaseRespVo.ok(order);
        return ok;
    }

    //付款
    @RequestMapping("wx/order/prepay")
    public BaseRespVo orderPrepay(@RequestBody OrderId orderId) {
        boolean flag = wxUserOrderService.orderPrepay(orderId.getOrderId());
        if (flag) {
            return BaseRespVo.ok(null);
        }
        return null;

    }

    @RequestMapping("wx/order/cancel")
    public BaseRespVo orderCancel(@RequestBody OrderId orderId) {
        boolean flag = wxUserOrderService.orderCancel(orderId.getOrderId());
        if (flag) {
            return BaseRespVo.ok(null);
        }
        return null;
    }

    @RequestMapping("wx/order/confirm")
    public BaseRespVo orderConfirm(@RequestBody OrderId orderId) {
        boolean flag = wxUserOrderService.orderConfirm(orderId.getOrderId());
        if (flag) {
            return BaseRespVo.ok(null);
        }
        return null;
    }

    @RequestMapping("wx/order/delete")
    public BaseRespVo orderDelete(@RequestBody OrderId orderId){
        boolean flag = wxUserOrderService.orderDeleteByOid(orderId.getOrderId());
        if (flag){
            return BaseRespVo.ok(null);
        }
        return null;
    }

    @RequestMapping("wx/order/refund")
    public BaseRespVo orderRefund(@RequestBody OrderId orderId){
        boolean flag = wxUserOrderService.orderRefund(orderId.getOrderId());
        if (flag){
            return BaseRespVo.ok(null);
        }
        return null;
    }
}
