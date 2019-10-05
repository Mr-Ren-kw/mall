package com.j4h.mall.service.wx.user;

import com.github.pagehelper.PageHelper;
import com.j4h.mall.mapper.mall.OrderMapper;
import com.j4h.mall.mapper.user.UserMapper;
import com.j4h.mall.model.wx.user.AllGoodsList;
import com.j4h.mall.model.wx.user.GoodsList;
import com.j4h.mall.model.wx.user.HandleOption;
import com.j4h.mall.model.wx.user.UserOrderDetailsList;
import com.j4h.mall.vo.wx.user.UserOrderPage;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class WxUserOrderServiceImp implements WxUserOrderService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderMapper orderMapper;

    @Override
    public AllGoodsList queryAllOrderList(UserOrderPage userOrderPage) {
        /* 需要修改的userId*/
        Session session = SecurityUtils.getSubject().getSession();
        Integer userId= (Integer) session.getAttribute("userId");
       if (userId==null){
           return null;
       }
        String orderStatusText = null;
        int size = userOrderPage.getSize();
        PageHelper.startPage(userOrderPage.getPage(), size);
        int showType = userOrderPage.getShowType();
        AllGoodsList allGoodsList = new AllGoodsList();
        ArrayList<Integer> status = new ArrayList<>();
        HashMap<Integer, String> orderStatu = new HashMap<>();
        orderStatu.put(301, "待收货");
        orderStatu.put(401, "待评价");
        orderStatu.put(402, "待评价");
        orderStatu.put(101, "待付款");
        orderStatu.put(201, "待发货");
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
            orderStatusText = orderStatu.get(stat);
            datum.setOrderStatusText(orderStatusText);
            List<GoodsList> goodsList = orderMapper.queryGoodsByOrderId(id);
            for (GoodsList list : goodsList) {
                int id1 = list.getId();
                String picUrl = orderMapper.queryPicUrlById(id1);
                list.setPicUrl(picUrl);
            }
            datum.setGoodsList(goodsList);
            HandleOption handleOption = new HandleOption();
            if (stat == 101) {
                handleOption.setCancel(true);
                handleOption.setPay(true);
            } else if (stat == 201) {
                handleOption.setRefund(true);
            } else if (stat == 301) {
                handleOption.setConfirm(true);
            } else if (stat == 401 || stat == 402) {
                handleOption.setComment(true);
            }
            datum.setHandleOption(handleOption);
        }
        allGoodsList.setData(data);
        allGoodsList.setCount(count);
        allGoodsList.setTotalPages(totalPage);
        return allGoodsList;
    }
}
