package com.j4h.mall.service.wx.order;

import com.j4h.mall.model.wx.order.OrderSubmit;
import com.j4h.mall.model.wx.user.AllGoodsList;
import com.j4h.mall.model.wx.order.ResultOrder;
import com.j4h.mall.vo.wx.order.OrderId;
import com.j4h.mall.vo.wx.order.SubmitOrder;
import com.j4h.mall.vo.wx.user.UserOrderPage;



public interface WxUserOrderService {
    AllGoodsList queryAllOrderList(UserOrderPage userOrderPage);

    ResultOrder querySingleOrderByOrderId(int orderId);

    boolean orderPrepay(int orderId);

    boolean orderCancel(int orderId);

    boolean orderConfirm(int orderId);

    boolean orderDeleteByOid(int orderId);

    boolean orderRefund(int orderId);

    OrderSubmit orderSubmitMany(SubmitOrder submitOrder);

    OrderSubmit orderSubmitOne(SubmitOrder submitOrder);
}
