package com.j4h.mall.mapper.mall;

import com.j4h.mall.model.mall.region.RegionProvince;

import java.util.List;

public interface RegionMapper {
    // 查询省份
    List<RegionProvince> getRegionProvinceList();
}
