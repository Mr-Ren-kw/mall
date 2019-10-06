package com.j4h.mall.service.wx.region;

import com.j4h.mall.mapper.mall.RegionMapper;
import com.j4h.mall.model.wx.region.WxRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxRegionServiceImpl implements WxRegionService {
    
    @Autowired
    RegionMapper regionMapper;
    
    @Override
    public List<WxRegion> queryRegionListByPid(int pid) {
        return regionMapper.queryRegionListByPidForWx(pid);
    }
}
