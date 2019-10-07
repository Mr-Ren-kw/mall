package com.j4h.mall.mapper.mall;

import com.j4h.mall.model.mall.order.Order;
import com.j4h.mall.model.mall.order.OrderGoods;
import com.j4h.mall.model.wx.user.GoodsList;
import com.j4h.mall.model.wx.user.UserOrderDetailsList;
import com.j4h.mall.vo.mall.order.ShipOrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface OrderMapper {
    List<Order> queryOrderList(@Param("userId") Integer userId,@Param("orderSn") Integer orderSn,@Param("orderStatusArray") Integer[] orderStatusArray);

    Order queryOrderById(@Param("id") int id);


    OrderGoods[] queryOrderGoodsByOid(@Param("oid") int id);

    int queryDetailOrderNumByUserId(@Param("id") int id, @Param("status")  ArrayList<Integer> status);

    List<UserOrderDetailsList> queryGoodsListByUserIdAndStatus(@Param("id")int userId, @Param("status")ArrayList<Integer> status);

    List<GoodsList> queryGoodsByOrderId(@Param("id") int id);

    String queryPicUrlById(@Param("id")int id);

    // 退款
    int refundOrderMoney(@Param("id") int orderId);

    int shipOrderById(@Param("ship") ShipOrderVo shipOrderVo);
}
