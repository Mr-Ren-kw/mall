package com.j4h.mall.service.wx.groupon;

import com.j4h.mall.mapper.extension.GrouponMapper;
import com.j4h.mall.mapper.goods.GoodsMapper;
import com.j4h.mall.model.wx.groupon.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WxGrouponServiceImpl implements WxGrouponService {

    @Autowired
    GrouponMapper grouponMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public WxGrouponPageBean queryGroupon(WxGrouponRequestBean wxGrouponRequestBean) {
        List<WxGrouponPageBean2> pageBean2List = grouponMapper.getIndexGrouponGoods(wxGrouponRequestBean);
        WxGrouponPageBean<WxGrouponPageBean2> pageBean = new WxGrouponPageBean<>();
        pageBean.setData(pageBean2List);
        int size = wxGrouponRequestBean.getSize();
        pageBean.setCount(size);

        return pageBean;
    }

    @Override
    public WxGrouponPageBean getMyGroupon(int userId, boolean isCreator) {
        List<WxMyGrouponKeyId> idLists = grouponMapper.getUserInitGroupOnKeyId(userId);
        WxGrouponPageBean userInitGropuonData = getGrouponMsgUtilMethod(idLists,userId,isCreator);

        return userInitGropuonData;
    }

    private WxGrouponPageBean getGrouponMsgUtilMethod(List<WxMyGrouponKeyId> idLists, Integer userId, boolean isCreator) {
        List<WxMyGrouponData> data = new ArrayList<>();
        for (WxMyGrouponKeyId Id : idLists) {
            WxMyGrouponData wxMyGrouponData = new WxMyGrouponData();
            WxMyGrouponOrderBean orderBean = grouponMapper.getGrouponOrderMsg(Id);
            String text = grouponMapper.getOrderStatusText(orderBean.getOrderStatus());
            List<WxMyGrouponGoodsBean> goodLists = grouponMapper.getGrouponGoods(Id);
            WxMyGroupon groupon = grouponMapper.getGrouponMsg(Id);
            WxMyHandleOption handleOption = getHandleOption(orderBean.getOrderStatus());
            int joinerCount = grouponMapper.getJoinerCount(Id);
            wxMyGrouponData.setActualPrice(orderBean.getActualPrice());
            wxMyGrouponData.setCreator(isCreator);
            wxMyGrouponData.setGoodsList(goodLists);
            wxMyGrouponData.setGroupon(groupon);
            wxMyGrouponData.setHandleOption(handleOption);
            wxMyGrouponData.setJoinerCount(joinerCount);
            wxMyGrouponData.setOrderId(orderBean.getOrderId());
            wxMyGrouponData.setOrderSn(orderBean.getOrderSn());
            wxMyGrouponData.setOrderStatusText(text);
            data.add(wxMyGrouponData);
        }

        WxGrouponPageBean<WxMyGrouponData> gropuonData = new WxGrouponPageBean<>();
        gropuonData.setData(data);
        int size = grouponMapper.getMyGroupOnCount(userId);
        gropuonData.setCount(size);
        return gropuonData;
    }

    private WxMyHandleOption getHandleOption(int orderStatus) {
        WxMyHandleOption handleOption = new WxMyHandleOption();
        if (orderStatus == 201){
            handleOption.setPay(true);
        }else if ((orderStatus == 102) || (orderStatus == 103)){
            handleOption.setCancel(false);
        }else if ((orderStatus == 401) || (orderStatus == 402)){
            handleOption.setComment(true);
        }
        return handleOption;
    }

    @Override
    public WxGrouponPageBean getMyJoinGroupOn(int userId, boolean isCreator) {
        List<WxMyGrouponKeyId> idLists = grouponMapper.getUserJoinGroupOnKeyId(userId);
        WxGrouponPageBean UserJoinGropuonData = getGrouponMsgUtilMethod(idLists,userId, isCreator);

        return UserJoinGropuonData;
    }
}
