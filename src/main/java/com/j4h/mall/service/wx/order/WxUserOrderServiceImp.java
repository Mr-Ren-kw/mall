package com.j4h.mall.service.wx.order;

import com.github.pagehelper.PageHelper;
import com.j4h.mall.mapper.address.AddressMapper;
import com.j4h.mall.mapper.cart.CartMapper;
import com.j4h.mall.mapper.extension.CouUserMapper;
import com.j4h.mall.mapper.extension.CouponMapper;
import com.j4h.mall.mapper.goods.GoodsMapper;
import com.j4h.mall.mapper.mall.OrderMapper;
import com.j4h.mall.mapper.user.UserMapper;
import com.j4h.mall.model.mall.order.Order;
import com.j4h.mall.model.mall.order.OrderGoods;
import com.j4h.mall.model.user.Address;
import com.j4h.mall.model.wx.address.WxAddressDetail;
import com.j4h.mall.model.wx.cart.Cart;
import com.j4h.mall.model.wx.order.OrderSubmit;
import com.j4h.mall.model.wx.user.AllGoodsList;
import com.j4h.mall.model.wx.user.GoodsList;
import com.j4h.mall.model.wx.user.HandleOption;
import com.j4h.mall.model.wx.user.UserOrderDetailsList;
import com.j4h.mall.model.wx.order.OrderGoodsDetailWx;
import com.j4h.mall.model.wx.order.WxOrder;
import com.j4h.mall.model.wx.order.ResultOrder;
import com.j4h.mall.vo.wx.order.SubmitOrder;
import com.j4h.mall.vo.wx.user.UserOrderPage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class WxUserOrderServiceImp implements WxUserOrderService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderMapper orderMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    CartMapper cartMapper;

    @Autowired
    CouponMapper couponMapper;

    @Autowired
    AddressMapper addressMapper;

    @Autowired
    CouUserMapper couUserMapper;

    public static String getOrderStatusTest(int stat) {
        HashMap<Integer, String> orderStatu = new HashMap<>();
        orderStatu.put(301, "待收货");
        orderStatu.put(401, "待评价");
        orderStatu.put(402, "待评价");
        orderStatu.put(101, "待付款");
        orderStatu.put(201, "待发货");
        return orderStatu.get(stat);
    }

    public static HandleOption getOneHandleOption(int stat) {
        HandleOption handleOption = new HandleOption();
        if (stat == 101) {
            handleOption.setCancel(true);
            handleOption.setPay(true);
        } else if (stat == 201) {
            handleOption.setRefund(true);
        } else if (stat == 301) {
            handleOption.setConfirm(true);
            handleOption.setRefund(true);
        } else if (stat == 401 || stat == 402) {
            handleOption.setComment(true);
            handleOption.setRebuy(true);
            handleOption.setDelete(true);
        }
        return handleOption;
    }

    @Override
    public AllGoodsList queryAllOrderList(UserOrderPage userOrderPage) {
        /* 需要修改的userId*/
        Session session = SecurityUtils.getSubject().getSession();
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return null;
        }
        int size = userOrderPage.getSize();
        PageHelper.startPage(userOrderPage.getPage(), size);
        int showType = userOrderPage.getShowType();
        AllGoodsList allGoodsList = new AllGoodsList();
        ArrayList<Integer> status = new ArrayList<>();
        HandleOption h = new HandleOption();
        int count = 0;
        int totalPage = 0;
        if (showType == 0) {
            status.add(301);
            status.add(401);
            status.add(402);
            status.add(101);
            status.add(201);
        } else if (showType == 1) {
            status.add(101);
        } else if (showType == 2) {
            status.add(201);
        } else if (showType == 3) {
            status.add(301);
        } else if (showType == 4) {
            status.add(401);
            status.add(402);
        }

        count = orderMapper.queryDetailOrderNumByUserId(userId, status);
        if (count != 0) {
            if (count % size == 0) {
                totalPage = count / size;
            } else {
                totalPage = count / size + 1;
            }
        }
        List<UserOrderDetailsList> data = orderMapper.queryGoodsListByUserIdAndStatus(userId, status);
        for (UserOrderDetailsList datum : data) {
            int id = datum.getId();
            int stat = datum.getStatu();
            String orderStatusText = getOrderStatusTest(stat);
            datum.setOrderStatusText(orderStatusText);
            List<GoodsList> goodsList = goodsMapper.queryGoodsByOrderId(id);
            for (GoodsList list : goodsList) {
                int id1 = list.getId();
                String picUrl = goodsMapper.queryPicUrlById(id1);
                list.setPicUrl(picUrl);
            }
            datum.setGoodsList(goodsList);
            HandleOption handleOption = getOneHandleOption(stat);
            datum.setHandleOption(handleOption);
        }
        allGoodsList.setData(data);
        allGoodsList.setCount(count);
        allGoodsList.setTotalPages(totalPage);
        return allGoodsList;
    }

    @Override
    public ResultOrder querySingleOrderByOrderId(int orderId) {
        ResultOrder resultOrder = new ResultOrder();
        WxOrder order = orderMapper.queryOrderByIdWx(orderId);
        int statu = order.getStatu();
        String orderStatusTest = getOrderStatusTest(statu);
        order.setOrderStatusTest(orderStatusTest);
        HandleOption handleOption = getOneHandleOption(statu);
        order.setHandleOption(handleOption);
        List<OrderGoods> orderGoods = orderMapper.queryOrderGoodsListByOid(orderId);
        for (OrderGoods orderGood : orderGoods) {
            int goodsId = orderGood.getGoodsId();
            String picUrl = goodsMapper.queryPicUrlById(goodsId);
            orderGood.setPicUrl(picUrl);
        }
        resultOrder.setOrderInfo(order);
        resultOrder.setOrderGoods(orderGoods);
        return resultOrder;
    }

    @Override
    public boolean orderPrepay(int orderId) {
        int status = 201;
        int i = orderMapper.updateOrderStatusByOidWx(orderId, status);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean orderCancel(int orderId) {
        int i = orderMapper.cancelOrderByOrderId(orderId);
        if (i > 0) {
            OrderGoodsDetailWx goods = orderMapper.queryGoodsDetailByOrderIdWx(orderId);
            int updateGoodsNumber = goodsMapper.updateGoodsNumberByGoodsIdWx(goods.getProductId(), goods.getNumber());
            if (updateGoodsNumber > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean orderConfirm(int orderId) {
        int i = orderMapper.orderConfirmByOid(orderId);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean orderDeleteByOid(int orderId) {
        int UpdateOrder = orderMapper.orderDeleteByOid(orderId);
        int updateOrderGoodsDeleted = orderMapper.updateDeleteInOrderGoodsByOid(orderId);
        if (UpdateOrder > 0 && updateOrderGoodsDeleted > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean orderRefund(int orderId) {
        int update = orderMapper.orderRefundByOid(orderId);
        if (update > 0) {
            return true;
        }
        return false;
    }

    @Override
    public OrderSubmit orderSubmitMany(SubmitOrder submitOrder) {
        int userId = (int) SecurityUtils.getSubject().getSession().getAttribute("userId");
        double sumPrice = 0;
        List<Cart> carts = cartMapper.queryCartByUserIdWx(userId);
        for (Cart cart : carts) {
            int goodsNumber = goodsMapper.queryGoodsNumberByProductId(cart.getProductId());
            if (cart.getNumber() > goodsNumber) {
                return null;
            }
            sumPrice = sumPrice + cart.getPrice() * cart.getNumber();
        }
        for (Cart cart : carts) {
            int number = cart.getNumber();
            int productId = cart.getProductId();
            int number1 = goodsMapper.updateGoodsNumberByGoodsIdWx(productId, -number);
            if (number1<1){
                return null;
            }
        }
        int updateDeleted = cartMapper.updateDeletedByUserIdWx(userId);
        if (updateDeleted > 0) {
            double freightPrice = 8;
            int couponId = submitOrder.getCouponId();
            double discountMoney = 0;
            if (couponId != 0) {
                discountMoney = couponMapper.queryCouponById(couponId).getDiscount();
            }
            if (sumPrice > 88) {
                freightPrice = 0;
            }
            double actualPrice = sumPrice - discountMoney + freightPrice;
            int comment = carts.size();
            Order order = new Order();
            WxAddressDetail addressDetail = addressMapper.getAddressDetailById(submitOrder.getAddressId());
            String address = addressDetail.getAddress();
            String mobile = addressDetail.getMobile();
            String name = addressDetail.getName();
            double goodsPrice = sumPrice;
            double integralPrice = 0.0;
            double grouponPrice = 0.0;
            double orderPrice = actualPrice;
            orderMapper.insertNewOrder(userId, getOrderSn(), submitOrder.getMessage(), freightPrice, discountMoney, orderPrice, actualPrice
                    , comment,order,address,mobile,name,goodsPrice,integralPrice,grouponPrice);
            if (couponId != 0) {
              int updateCouponStatus=  couUserMapper.updateCouponStatusByCouponId(couponId,order.getId(),userId);
              if (updateCouponStatus<1){
                  return null;
              }
            }
            OrderSubmit orderSubmit = new OrderSubmit();
            orderSubmit.setOrderId(order.getId());
            return orderSubmit;
        }
        return null;
    }

    public static String getOrderSn() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String orderSn = dateFormat.format(date);
        orderSn = orderSn + (int) (Math.random() * 1000000 + 1);
        return orderSn;
    }

    @Override
    public OrderSubmit orderSubmitOne(SubmitOrder submitOrder) {
        return null;
    }


}
