package com.j4h.mall.mapper.mall;

import com.j4h.mall.model.mall.order.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    List<Order> queryOrderList(@Param("userId") Integer userId,@Param("orderSn") Integer orderSn,@Param("orderStatusArray") Integer[] orderStatusArray);
}