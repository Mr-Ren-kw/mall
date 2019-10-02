package com.j4h.mall.service.mall;

import com.j4h.mall.model.PageBean;
import com.j4h.mall.model.mall.order.Order;

public interface OrderService {
    PageBean<Order> queryOrderList(int page, int limit, String sort, String order,Integer userId,Integer orderSn,Integer[] orderStatusArray);
}
