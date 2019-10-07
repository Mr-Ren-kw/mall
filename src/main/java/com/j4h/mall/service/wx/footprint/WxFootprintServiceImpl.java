package com.j4h.mall.service.wx.footprint;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.user.UserMapper;
import com.j4h.mall.model.wx.footprint.FootprintDataBean;
import com.j4h.mall.model.wx.footprint.FootprintList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxFootprintServiceImpl implements WxFootprintService{

    @Autowired
    UserMapper userMapper;

    @Override
    public FootprintDataBean getFootprintList(int page, int size, Integer userId) {
        String sort = "add_time";
        String order = "desc";
        PageHelper.startPage(page,size,sort + " " + order);
        int[] goodsIds = userMapper.getUserFootprintGoodsIds(userId);
        List<FootprintList> footprintLists = userMapper.getFootprintList(goodsIds);
        PageInfo<FootprintList> pageInfo = new PageInfo<>(footprintLists);
        long totalPages = pageInfo.getTotal();


        FootprintDataBean dataBean = new FootprintDataBean();
        dataBean.setFootprintList(footprintLists);
        dataBean.setTotalPages(totalPages);
        return dataBean;
    }
}
