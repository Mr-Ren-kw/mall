package com.j4h.mall.service.wx.collect;

import com.j4h.mall.model.wx.collect.Collect;
import com.j4h.mall.model.wx.collect.CollectPageBean;
import com.j4h.mall.model.wx.collect.CollectType;

public interface CollectService {
    CollectType addOrDeleteCollect(Integer userId, Collect collect);

    CollectPageBean getCollectList(Integer userId, int type, int page, int size);

}
