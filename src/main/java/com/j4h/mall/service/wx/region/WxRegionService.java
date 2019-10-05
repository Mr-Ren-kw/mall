package com.j4h.mall.service.wx.region;

import com.j4h.mall.model.wx.region.WxRegion;

import java.util.List;

public interface WxRegionService {
    List<WxRegion> queryRegionListByPid(int pid);
}
