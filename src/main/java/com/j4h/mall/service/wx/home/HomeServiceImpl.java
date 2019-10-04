package com.j4h.mall.service.wx.home;

import com.j4h.mall.mapper.extension.AdMapper;
import com.j4h.mall.mapper.extension.CouponMapper;
import com.j4h.mall.mapper.extension.GrouponMapper;
import com.j4h.mall.mapper.extension.TopicMapper;
import com.j4h.mall.mapper.goods.GoodsMapper;
import com.j4h.mall.mapper.mall.BrandMapper;
import com.j4h.mall.mapper.mall.CategoryMapper;
import com.j4h.mall.model.extension.topic.BeanForDatabase.Topic;
import com.j4h.mall.vo.wx.home.BeanForData.HomeData;
import org.springframework.beans.factory.annotation.Autowired;

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
    GrouponMapper grouponMapper;
    @Autowired
    TopicMapper topicMapper;

    @Override
    public HomeData queryHomeData() {
        HomeData homeData = new HomeData();

        return homeData;
    }
}
