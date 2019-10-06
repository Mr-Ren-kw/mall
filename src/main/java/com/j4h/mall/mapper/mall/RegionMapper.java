package com.j4h.mall.mapper.mall;

import com.j4h.mall.model.mall.region.RegionProvince;
import com.j4h.mall.model.wx.region.WxRegion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegionMapper {
    // 查询省份
    List<RegionProvince> getRegionProvinceList();

    List<WxRegion> queryRegionListByPidForWx(@Param("pid") int pid);

    String queryRegionNameById(@Param("id") int id);
}
