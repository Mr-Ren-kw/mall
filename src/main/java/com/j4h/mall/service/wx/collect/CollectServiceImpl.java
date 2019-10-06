package com.j4h.mall.service.wx.collect;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.collect.CollectMapper;
import com.j4h.mall.model.wx.collect.Collect;
import com.j4h.mall.model.wx.collect.CollectInfo;
import com.j4h.mall.model.wx.collect.CollectPageBean;
import com.j4h.mall.model.wx.collect.CollectType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    CollectMapper collectMapper;

    @Override
    public CollectType addOrDeleteCollect(Integer userId, Collect collect) {
        int valueId = collect.getValueId();
        int type = collect.getType();
        CollectType collectType = new CollectType();
        Collect coll = collectMapper.getCollectByUidValueIdType(userId, valueId, type);
        if (coll == null) {
            collectType.setType("add");
            collectMapper.insertCollect(userId, valueId, type);
        } else {
            collectType.setType("delete");
            collectMapper.deleteCollect(userId, valueId, type);
        }
        return collectType;
    }

    @Override
    public CollectPageBean getCollectList(Integer userId, int type, int page, int size) {
        PageHelper.startPage(page, size);
        List<CollectInfo> collectInfos = collectMapper.getCollectsByUidType(userId, type);
        PageInfo<CollectInfo> pageInfo = new PageInfo<>(collectInfos);
        long total = pageInfo.getTotal();
        CollectPageBean collectPageBean = new CollectPageBean();
        collectPageBean.setCollectList(collectInfos);
        collectPageBean.setTotalPages(total);
        return collectPageBean;
    }
}
