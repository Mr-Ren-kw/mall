package com.j4h.mall.mapper.mall;

import com.j4h.mall.model.mall.RegionArea;
import com.j4h.mall.model.mall.RegionCity;
import com.j4h.mall.model.mall.RegionProvince;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegionMapper {
    // 查询省份
    List<RegionProvince> getRegionProvinceList();
    // 根据省份id查询城市
    List<RegionCity> getRegionCityListByPid(@Param("pid")int pid);
    // 根据城市id查询区域
    List<RegionArea> getRegionAreaListByCid(@Param("cid")int cid);
}
