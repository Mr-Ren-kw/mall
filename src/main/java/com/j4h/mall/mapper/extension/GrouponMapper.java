package com.j4h.mall.mapper.extension;

import com.j4h.mall.model.extension.groupon.BeanForDatabase.Groupon;
import com.j4h.mall.model.extension.groupon.BeanForDatabase.GrouponUser;
import com.j4h.mall.model.wx.groupon.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GrouponMapper {
    List<Groupon> queryGrouponByCondition(@Param("goodsId") int goodsId);

    GrouponUser[] queryParticipanter(@Param("id") int creatorUserId);

    //查询，显示首页团购专区中的商品 author：lisen
    List<WxGrouponPageBean2> getIndexGrouponGoods(@Param("wxGrouponBean") WxGrouponRequestBean wxGrouponRequestBean);

    //根据userID查询用户发起的团购次数 author：lisen
    int getMyGroupOnCount(@Param("userId") int userId);

    //根据userID从Groupon数据表中查询 用户“发起”团购 关键字段的id author：lisen
    List<WxMyGrouponKeyId> getUserInitGroupOnKeyId(@Param("userId") int userId);

    //根据userID从groupon数据表中查询 用户“加入”团购 关键字段的id author：lisen
    List<WxMyGrouponKeyId> getUserJoinGroupOnKeyId(@Param("userId") int userId);

    //根据关键字段的id 从order数据表中查询对应字段 author：lisen
    WxMyGrouponOrderBean getGrouponOrderMsg(@Param("id") WxMyGrouponKeyId id);

    //根据订单状态status 从order-status数据表中查询对应信息 author：lisen
    String getOrderStatusText(@Param("orderStatus") int orderStatus);

    //根据用户团购的商品的id 去groupon-rules表中查找对应goods信息
    List<WxMyGrouponGoodsBean> getGrouponGoods(@Param("id") WxMyGrouponKeyId id);

    //根据用户团购的grouponid 去Groupon表中查询对应团购信息
    WxMyGroupon getGrouponMsg(@Param("id") WxMyGrouponKeyId id);

    //根据关键字段id  去Groupon表中查询 参加团购的人数
    int getJoinerCount(@Param("id") WxMyGrouponKeyId id);
}
