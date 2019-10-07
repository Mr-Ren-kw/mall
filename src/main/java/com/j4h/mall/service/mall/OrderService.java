package com.j4h.mall.service.mall;

import com.j4h.mall.model.PageBean;
import com.j4h.mall.model.mall.order.Order;
import com.j4h.mall.model.mall.order.OrderDetail;
import com.j4h.mall.vo.mall.order.ShipOrderVo;

public interface OrderService {
    PageBean<Order> queryOrderList(int page, int limit, String sort, String order,Integer userId,Integer orderSn,Integer[] orderStatusArray);

    OrderDetail queryOrderDetail(int id);

    // 退款
    int refundOrderMoney(int orderId);
    // 发货
    int shipOrder(ShipOrderVo shipOrderVo);
}
