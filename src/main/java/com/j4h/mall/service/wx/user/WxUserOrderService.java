package com.j4h.mall.service.wx.user;

import com.j4h.mall.model.wx.user.AllGoodsList;
import com.j4h.mall.vo.wx.user.UserOrderPage;



public interface WxUserOrderService {
    AllGoodsList queryAllOrderList(UserOrderPage userOrderPage);
}
