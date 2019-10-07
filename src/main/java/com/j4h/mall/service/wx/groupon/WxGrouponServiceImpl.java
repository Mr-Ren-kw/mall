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
        int[] orderIds = grouponMapper.getGrouponOrderIds(userId);
        WxGrouponPageBean userInitGropuonData = getGrouponMsgUtilMethod(orderIds,userId,isCreator);

        return userInitGropuonData;
    }

    private WxGrouponPageBean getGrouponMsgUtilMethod(int[] orderIds, Integer userId, boolean isCreator) {
        List<WxMyGrouponData> data = new ArrayList<>();
        for (int orderId : orderIds) {
            int[] goodsIds = null;
            if (isCreator){
                goodsIds = grouponMapper.getGrouponGoodsIds(orderId,userId);
            }else {
                goodsIds = grouponMapper.getJoinGrouponGoodsIds(orderId,userId);
            }
            WxMyGrouponData wxMyGrouponData = grouponMapper.getTemp(orderId,userId);
            List<WxMyGrouponGoodsBean> goodLists = grouponMapper.getGrouponGoods(goodsIds);
            WxMyGroupon groupon = grouponMapper.getGrouponMsg(orderId,userId);
            int orderStatus = grouponMapper.getGrouponOrderStatus(orderId);
            WxMyHandleOption handleOption = getHandleOption(orderStatus);
            WxMyRules rules = grouponMapper.getGrouponRules(groupon.getRulesId());

            wxMyGrouponData.setIsCreator(isCreator);
            wxMyGrouponData.setGoodsList(goodLists);
            wxMyGrouponData.setGroupon(groupon);
            wxMyGrouponData.setHandleOption(handleOption);
            wxMyGrouponData.setRules(rules);
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

        int[] orderIds = grouponMapper.getJoinGrouponOrderIds(userId);

        WxGrouponPageBean UserJoinGropuonData = getGrouponMsgUtilMethod(orderIds,userId, isCreator);

        return UserJoinGropuonData;
    }

    @Override
    public WxGrouponDetail getWxGrouponDetail(int grouponId) {
        WxGrouponDetail data = new WxGrouponDetail();

        int userId = grouponMapper.getGrouponUserid(grouponId);

        WxGrouponCreator creator = grouponMapper.getGrouponCreator(userId);

        int orderid = grouponMapper.getGrouponOrderIdByGid(grouponId);

        WxMyGroupon groupon = grouponMapper.getGrouponMsg(orderid,userId);

        int[] joinersId = grouponMapper.getGrouponJoinerUserIds(grouponId);

        List<WxGrouponJoiners> joiners = grouponMapper.getGrouponJoiners(joinersId);

        List<WxGrouponOrderGoods> orderGoods = grouponMapper.getGrouponOrderGoods(orderid);
        for (WxGrouponOrderGoods orderGood : orderGoods) {
            int goodsId = orderGood.getGoodsId();
            double retailPrice = grouponMapper.getGrouponGoodsRetailPrice(goodsId);
            String[] spec = grouponMapper.getGrouponGoodsSpec(goodsId);
            orderGood.setGoodsSpecificationsValues(spec);
            orderGood.setRetailPrice(retailPrice);
        }

        WxGrouponOrderInfo orderInfo = grouponMapper.getGrouponOrderInfo(orderid);
        int orderStatus = grouponMapper.getGrouponOrderStatus(orderid);
        WxMyHandleOption handleOption = getHandleOption(orderStatus);
        orderInfo.setHandleOption(handleOption);

        WxMyRules rules = grouponMapper.getGrouponRules(groupon.getRulesId());

        data.setCreator(creator);
        data.setGroupon(groupon);
        data.setJoiners(joiners);
        data.setLinkGrouponId(grouponId);
        data.setOrderGoods(orderGoods);
        data.setOrderInfo(orderInfo);
        data.setRules(rules);

        return data;
    }
}
