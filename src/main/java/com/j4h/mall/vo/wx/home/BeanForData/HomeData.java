package com.j4h.mall.vo.wx.home.BeanForData;

import com.j4h.mall.model.extension.ad.BeanForDatabase.Advertise;
import com.j4h.mall.model.extension.coupon.BeanForDatabase.Coupon;
import com.j4h.mall.model.extension.groupon.BeanForDatabase.Groupon;
import com.j4h.mall.model.extension.topic.BeanForDatabase.Topic;
import com.j4h.mall.model.goods.Category;
import com.j4h.mall.model.goods.FloorGoods;
import com.j4h.mall.model.goods.Goods;
import com.j4h.mall.model.mall.brand.Brand;

import java.util.List;

public class HomeData {
    private List<Advertise> banner;
    private List<Brand> brandList;
    private List<Category> channel;
    private List<Coupon> couponList;
    private List<FloorGoods> floorGoodsList;
    private List<Groupon> grouponList;
    private List<Goods> hotGoodsList;
    private List<Goods> newGoodsList;
    private List<Topic> topicList;

    public List<Advertise> getBanner() {
        return banner;
    }

    public void setBanner(List<Advertise> banner) {
        this.banner = banner;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public List<Category> getChannel() {
        return channel;
    }

    public void setChannel(List<Category> channel) {
        this.channel = channel;
    }

    public List<Coupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<Coupon> couponList) {
        this.couponList = couponList;
    }

    public List<FloorGoods> getFloorGoodsList() {
        return floorGoodsList;
    }

    public void setFloorGoodsList(List<FloorGoods> floorGoodsList) {
        this.floorGoodsList = floorGoodsList;
    }

    public List<Groupon> getGrouponList() {
        return grouponList;
    }

    public void setGrouponList(List<Groupon> grouponList) {
        this.grouponList = grouponList;
    }

    public List<Goods> getHotGoodsList() {
        return hotGoodsList;
    }

    public void setHotGoodsList(List<Goods> hotGoodsList) {
        this.hotGoodsList = hotGoodsList;
    }

    public List<Goods> getNewGoodsList() {
        return newGoodsList;
    }

    public void setNewGoodsList(List<Goods> newGoodsList) {
        this.newGoodsList = newGoodsList;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }
}
