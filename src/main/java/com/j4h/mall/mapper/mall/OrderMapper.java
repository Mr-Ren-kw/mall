package com.j4h.mall.mapper.mall;

import com.j4h.mall.model.mall.order.Order;
import com.j4h.mall.model.mall.order.OrderGoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    List<Order> queryOrderList(@Param("userId") Integer userId,@Param("orderSn") Integer orderSn,@Param("orderStatusArray") Integer[] orderStatusArray);

    Order queryOrderById(@Param("id") int id);


    OrderGoods[] queryOrderGoodsByOid(@Param("oid") int id);
}
