package com.j4h.mall.service.wx.user;

import com.j4h.mall.mapper.mall.OrderMapper;
import com.j4h.mall.mapper.user.UserMapper;
import com.j4h.mall.model.wx.user.UserOrderDetail;
import com.j4h.mall.util.LoginOrNotUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Service
public class WxUserServiceImp implements WxUserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    OrderMapper orderMapper;


    @Override
    public UserOrderDetail queryUserAllOrder() {
        UserOrderDetail userOrderDetail = new UserOrderDetail();
        Integer id = LoginOrNotUtils.getUserId();
        if (id==null){
            return null;
        }
        //待收货
        ArrayList<Integer> s1 = new ArrayList<>();
        s1.add(301);
        int unRecv = orderMapper.queryDetailOrderNumByUserId(id,s1);
        userOrderDetail.setUnrecv(unRecv);
        //待评价
        ArrayList<Integer> s2 = new ArrayList<>();
        s1.add(401);
        s1.add(402);
        int uncomment = orderMapper.queryDetailOrderNumByUserId(id,s2);
        userOrderDetail.setUncomment(uncomment);
        //待付款
        ArrayList<Integer> s3 = new ArrayList<>();
        s1.add(101);
        int unpaid =orderMapper.queryDetailOrderNumByUserId(id,s3);
        userOrderDetail.setUnpaid(unpaid);
        //待发货
        ArrayList<Integer> s4 = new ArrayList<>();
        s1.add(201);
        int unship =orderMapper.queryDetailOrderNumByUserId(id,s4);
        userOrderDetail.setUnship(unship);
        return userOrderDetail;
    }
}
