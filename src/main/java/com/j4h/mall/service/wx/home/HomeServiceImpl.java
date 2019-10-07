package com.j4h.mall.service.wx.home;

import com.github.pagehelper.PageHelper;
import com.j4h.mall.mapper.configs.ConfigMapper;
import com.j4h.mall.mapper.extension.*;
import com.j4h.mall.mapper.goods.GoodsMapper;
import com.j4h.mall.mapper.mall.BrandMapper;
import com.j4h.mall.mapper.mall.CategoryMapper;
import com.j4h.mall.model.extension.ad.BeanForDatabase.Advertise;
import com.j4h.mall.model.extension.coupon.BeanForDatabase.Coupon;
import com.j4h.mall.model.extension.groupon.BeanForDatabase.GrouponRules;
import com.j4h.mall.model.extension.topic.BeanForDatabase.Topic;
import com.j4h.mall.model.goods.Goods;
import com.j4h.mall.model.mall.brand.Brand;
import com.j4h.mall.model.mall.category.L1Category;
import com.j4h.mall.model.wx.home.FloorGoods;
import com.j4h.mall.model.wx.home.GrouponGoods;
import com.j4h.mall.model.wx.home.L1Categories;
import com.j4h.mall.vo.wx.home.BeanForData.HomeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    AdMapper adMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    BrandMapper brandMapper;
    @Autowired
    CouponMapper couponMapper;
    @Autowired
    GrouponRulesMapper grouponRulesMapper;
    @Autowired
    TopicMapper topicMapper;
    @Autowired
    ConfigMapper configMapper;

    @Override
    public HomeData queryHomeData() {
        HomeData homeData = new HomeData();
        int newGoodsNum = Integer.parseInt(configMapper.getMallSystemWxCatlogGoods());
        int hotGoodsNum = Integer.parseInt(configMapper.getMallSystemWxIndexHot());
        int brandNum = Integer.parseInt(configMapper.getMallSystemWxIndexBrand());
        int topicNum = Integer.parseInt(configMapper.getMallSystemWxIndexTopic());
        int categoryNum = Integer.parseInt(configMapper.getMallSystemWxCatlogList());
        int cateGoodsNum = Integer.parseInt(configMapper.getMallSystemWxCatlogGoods());
        List<Advertise> advertises = adMapper.queryAdsByCondition(null, null);
        PageHelper.startPage(1, brandNum);
        List<Brand> brandList = brandMapper.brandList(null, null);
        List<L1Categories> channel = new ArrayList<>();
        List<Coupon> couponList = couponMapper.queryCouponByCondition(null, -1, -1);
        List<GrouponGoods> grouponList = new ArrayList<>();
        List<GrouponRules> grouponRules = grouponRulesMapper.queryGrouponRulesByCondition(0);
        for (GrouponRules grouponRule : grouponRules) {
            GrouponGoods grouponGoods = new GrouponGoods();
            int goodsId = grouponRule.getGoodsId();
            Goods goods = goodsMapper.getGoodsById(goodsId);
            grouponGoods.setGroupon_price(new BigDecimal(goods.getRetailPrice()).subtract(grouponRule.getDiscount()));
            grouponGoods.setGroupon_member(grouponRule.getDiscountMember());
            grouponGoods.setGoods(goods);
            grouponList.add(grouponGoods);
        }
        PageHelper.startPage(1, hotGoodsNum);
        List<Goods> hotGoodsList = goodsMapper.queryHotGoods();
        PageHelper.startPage(1, newGoodsNum);
        List<Goods> newGoodsList = goodsMapper.queryNewGoods();
        PageHelper.startPage(1, topicNum);
        List<Topic> topicList = topicMapper.queryTopicByCondition(null, null);
        List<FloorGoods> floorGoodsList = new ArrayList<>();
        PageHelper.startPage(1, categoryNum);
        List<L1Category> l1Categories = categoryMapper.queryAllCategory();
        for (L1Category l1Category : l1Categories) {
            L1Categories category = new L1Categories();
            category.setIconUrl(l1Category.getIconUrl());
            category.setId(l1Category.getId());
            category.setName(l1Category.getName());
            channel.add(category);
            FloorGoods floorGoods = new FloorGoods();
            floorGoods.setId(l1Category.getId());
            floorGoods.setName(l1Category.getName());
            int l1Id = l1Category.getId();
            PageHelper.startPage(1, cateGoodsNum);
            List<Goods> goodsList = goodsMapper.queryGoodsByL1Id(l1Id);
            floorGoods.setGoodsList(goodsList);
            floorGoodsList.add(floorGoods);
        }
        homeData.setBanner(advertises);
        homeData.setBrandList(brandList);
        homeData.setChannel(channel);
        homeData.setCouponList(couponList);
        homeData.setFloorGoodsList(floorGoodsList);
        homeData.setGrouponList(grouponList);
        homeData.setHotGoodsList(hotGoodsList);
        homeData.setNewGoodsList(newGoodsList);
        homeData.setTopicList(topicList);
        return homeData;
    }
}
