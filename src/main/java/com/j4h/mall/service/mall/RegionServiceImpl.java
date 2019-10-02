package com.j4h.mall.service.mall;

import com.j4h.mall.mapper.mall.RegionMapper;
import com.j4h.mall.model.mall.region.RegionProvince;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    RegionMapper regionMapper;
    @Override
    public List<RegionProvince> regionList() {
        // 查询所有省份
        return regionMapper.getRegionProvinceList();
    }
}
