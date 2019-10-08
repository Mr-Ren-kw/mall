package com.j4h.mall.service.extension.groupon;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.extension.GrouponMapper;
import com.j4h.mall.mapper.extension.GrouponRulesMapper;
import com.j4h.mall.mapper.goods.GoodsMapper;
import com.j4h.mall.model.extension.groupon.BeanForDatabase.Groupon;
import com.j4h.mall.model.extension.groupon.BeanForDatabase.GrouponRules;
import com.j4h.mall.model.extension.groupon.BeanForDatabase.GrouponUser;
import com.j4h.mall.model.extension.groupon.BeanForItems.GrouponItem;
import com.j4h.mall.model.goods.Goods;
import com.j4h.mall.model.wx.groupon.WxMyRules;
import com.j4h.mall.vo.extension.BeanForData.PageData;
import com.j4h.mall.vo.extension.BeanForRequest.GrouponPageRequest;
import com.j4h.mall.vo.extension.BeanForRequest.GrouponRulesPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GrouponServiceImpl implements GrouponService {

    @Autowired
    GrouponRulesMapper grouponRulesMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    GrouponMapper grouponMapper;

    @Override
    public PageData queryGrouponRulesByPage(GrouponRulesPageRequest grouponRulesPageRequest) {
        PageData grouponRulesPageData = new PageData<GrouponRules>();
        Integer goodsId = null;
        if(grouponRulesPageRequest.getGoodsId() != null && !"".equals(grouponRulesPageRequest.getGoodsId())) {
            try {
                goodsId = Integer.parseInt(grouponRulesPageRequest.getGoodsId());
            } catch (NumberFormatException e) {
                return grouponRulesPageData;
            }
        }
        String orderBy = grouponRulesPageRequest.getSort() + " " + grouponRulesPageRequest.getOrder();
        PageHelper.startPage(grouponRulesPageRequest.getPage(), grouponRulesPageRequest.getLimit(), orderBy);
        List<GrouponRules> grouponRulesList = grouponRulesMapper.queryGrouponRulesByCondition(goodsId);
        PageInfo<GrouponRules> grouponRulesPageInfo = new PageInfo<>(grouponRulesList);
        long total = grouponRulesPageInfo.getTotal();
        grouponRulesPageData.setItems(grouponRulesList);
        grouponRulesPageData.setTotal((int)total);
        return grouponRulesPageData;
    }

    @Override
    public GrouponRules addGrouponRules(GrouponRules grouponRules) {
        Goods goods = goodsMapper.getGoodsById(grouponRules.getGoodsId());
        if(goods != null) {
            grouponRules.setPicUrl(goods.getPicUrl());
            grouponRules.setGoodsName(goods.getName());
            grouponRulesMapper.insertGrouponRules(grouponRules);
            return grouponRulesMapper.queryGrouponRulesById(grouponRules.getId());
        }
        return null;
    }

    @Override
    public void updateGrouponRules(GrouponRules grouponRules) {
        int newId = grouponRules.getGoodsId();
        int oldId = grouponRulesMapper.getGoodsIdById(grouponRules.getId());
        if(newId != oldId) {
            Goods goods = goodsMapper.getGoodsById(grouponRules.getGoodsId());
            if(goods == null) {
                throw new NumberFormatException();
            }
            grouponRules.setPicUrl(goods.getPicUrl());
            grouponRules.setGoodsName(goods.getName());
        }
        grouponRulesMapper.updateGrouponRules(grouponRules);
    }

    @Override
    public void deleteGrouponRulesById(int rulesId) {
        grouponRulesMapper.deleteRulesById(rulesId);
    }

    @Override
    public PageData queryGrouponByPage(GrouponPageRequest grouponPageRequest) {
        List<GrouponItem> grouponItems = new ArrayList<>();
        PageData grouponPageData = new PageData<Groupon>();
        Integer goodsId = null;
        if(grouponPageRequest.getGoodsId() != null && !"".equals(grouponPageRequest.getGoodsId())) {
            try {
                goodsId = Integer.parseInt(grouponPageRequest.getGoodsId());
            } catch (NumberFormatException e) {
                return grouponPageData;
            }
        }
        String orderBy = grouponPageRequest.getSort() + " " + grouponPageRequest.getOrder();
        PageHelper.startPage(grouponPageRequest.getPage(), grouponPageRequest.getLimit(), orderBy);
        List<Groupon> grouponList = grouponMapper.queryAllGroupon();
        for (Groupon groupon : grouponList) {
            GrouponItem grouponItem = new GrouponItem();
            WxMyRules wxMyRules = grouponMapper.getGrouponRules(groupon.getRulesId());
            Goods goods = goodsMapper.getGoodsById(wxMyRules.getGoodsId());
            GrouponUser[] grouponUsers = grouponMapper.queryParticipanter(groupon.getCreatorUserId());
            grouponItem.setSubGroupons(grouponUsers);
            grouponItem.setRules(wxMyRules);
            grouponItem.setGroupon(groupon);
            grouponItem.setGoods(goods);
            grouponItems.add(grouponItem);
        }
        grouponPageData.setItems(grouponItems);
        grouponPageData.setTotal(grouponList.size());
        return grouponPageData;
    }
}
