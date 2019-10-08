package com.j4h.mall.mapper.extension;

import com.j4h.mall.model.extension.groupon.BeanForDatabase.Groupon;
import com.j4h.mall.model.extension.groupon.BeanForDatabase.GrouponUser;
import com.j4h.mall.model.wx.groupon.*;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface GrouponMapper {

    GrouponUser[] queryParticipanter(@Param("id") int creatorUserId);


    //查询，显示首页团购专区中的商品 author：lisen
    List<WxGrouponPageBean2> getIndexGrouponGoods(@Param("wxGrouponBean") WxGrouponRequestBean wxGrouponRequestBean);

    //根据userID查询用户发起的团购次数 author：lisen
    int getMyGroupOnCount(@Param("userId") int userId);

    //根据用户团购的商品的id 去groupon-rules表中查找对应goods信息 author：lisen
    List<WxMyGrouponGoodsBean> getGrouponGoods(@Param("goodsIds") int[] goodsIds);

    //根据用户团购的grouponid 去Groupon表中查询对应团购信息 author：lisen
    WxMyGroupon getGrouponMsg(@Param("orderId") int orderId,
                              @Param("userId")int userId);

    //根据关键字段id 查询团购规则 author：lisen
    WxMyRules getGrouponRules(@Param("rulesId") int rulesId);

    //根据关键字段id 查询user表获得团购发起者的信息
    WxGrouponCreator getGrouponCreator(@Param("id") int userId);

    //根据关键字段id 查询参与团购的用户的信息
    List<WxGrouponJoiners> getGrouponJoiners(@Param("ids") int[] keyId);

    //根据关键字段id 查询所有参加团购用户的id
    int[] getGrouponJoinerUserIds(@Param("grouponId") int grouponId);

    //根据关键字段id 查询OrderGoods的信息
    List<WxGrouponOrderGoods> getGrouponOrderGoods(@Param("orderId") int orderId);

    //根据关键字段id 查询goods的retailprice
    double getGrouponGoodsRetailPrice(@Param("goodsId") int goodsId);

    //根据关键字段id 查询商品的spec
    String[] getGrouponGoodsSpec(@Param("goodsId") int goodsId);

    //根据关键字段id 查询 orderinfo
    WxGrouponOrderInfo getGrouponOrderInfo(@Param("orderId") int grouponId);

    //根据userID去Groupon表查询表中订单的id数组
    int[] getGrouponOrderIds(@Param("userId") int userId);

    //根据订单的id 去连接Groupon表与Grouponrules表查询goodsid数组
    int[] getGrouponGoodsIds(@Param("orderId") int orderId,@Param("userId") Integer userId);

    //基于Groupon表左连接联立查询user表，order表，order-status表
    WxMyGrouponData getTemp(@Param("orderId") int orderId,@Param("userId") Integer userId);

    //获得团购订单的状态码
    int getGrouponOrderStatus(@Param("orderId") int orderId);

    //获取参加购的订单的id数组
    int[] getJoinGrouponOrderIds(@Param("userId") int userId);

    //获取Groupon表中的useID信息
    int getGrouponUserid(@Param("grouponId") int grouponId);

    //根据Groupon表的id获取orderID
    int getGrouponOrderIdByGid(@Param("grouponId") int grouponId);

    //查找参加团购的goodsid
    int[] getJoinGrouponGoodsIds(@Param("orderId") int orderId,@Param("userId") Integer userId);

    Groupon queryGrouponByRuleId(@Param("id") Integer rulesId);

}
