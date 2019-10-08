package com.j4h.mall.mapper.mall;

import com.j4h.mall.model.mall.order.Order;
import com.j4h.mall.model.mall.order.OrderGoods;
import com.j4h.mall.model.wx.cart.Cart;
import com.j4h.mall.model.wx.user.GoodsList;
import com.j4h.mall.model.wx.user.UserOrderDetailsList;
import com.j4h.mall.vo.mall.order.ShipOrderVo;
import com.j4h.mall.model.wx.order.OrderGoodsDetailWx;
import com.j4h.mall.model.wx.order.WxOrder;
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


    WxOrder queryOrderByIdWx(@Param("id") int orderId);

    List<OrderGoods> queryOrderGoodsListByOid(@Param("oid") int orderId);

    int updateOrderStatusByOidWx(@Param("id") int id,@Param("status")int statu);

    int cancelOrderByOrderId(@Param("id") int orderId);

    OrderGoodsDetailWx queryGoodsDetailByOrderIdWx(@Param("id") int orderId);

    int orderConfirmByOid(@Param("id") int orderId);

    int orderDeleteByOid(@Param("id") int orderId);

    int updateDeleteInOrderGoodsByOid(@Param("id") int orderId);


    int orderRefundByOid(@Param("id") int orderId);

    int insertNewOrder(@Param("userId") int userId, @Param("orderSn") String orderSn,
                       @Param("message") String message,@Param("freightPrice") double freightPrice,
                       @Param("couponPrice") double discountMoney, @Param("orderPrice") double actualPrice,
                       @Param("actualPrice") double actualPrice1, @Param("comment") int comment,
                       @Param("order")Order order,@Param("address")String address,
                         @Param("mobile")String mobile,@Param("name")String name,
                       @Param("goodsPrice")double goodsPrice,@Param("integralPrice")double integralPrice,@Param("grouponPrice")double grouponPrice);

    int insertNewOrderGoods(@Param("orderId") int id,@Param("carts") List<Cart> carts);
}
