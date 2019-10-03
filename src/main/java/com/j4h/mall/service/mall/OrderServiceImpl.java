package com.j4h.mall.service.mall;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.mall.OrderMapper;
import com.j4h.mall.model.PageBean;
import com.j4h.mall.model.mall.order.Order;
import com.j4h.mall.model.mall.order.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public PageBean<Order> queryOrderList(int page, int limit, String sort, String order,Integer userId,Integer orderSn,Integer[] orderStatusArray) {
        PageHelper.startPage(page,limit,sort + " " + order);
        List<Order> orderList = orderMapper.queryOrderList(userId,orderSn,orderStatusArray);
        PageInfo<Order> pageInfo = new PageInfo<>(orderList);
        long total = pageInfo.getTotal();
        PageBean<Order> pageBean = new PageBean<>();
        pageBean.setTotal(total);
        pageBean.setItems(orderList);
        return pageBean;
    }

    @Override
    public OrderDetail queryOrderDetail(int id) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder(orderMapper.queryOrderById(id));
        // 查询goods表
        // 查询user表
        return orderDetail;
    }
}
