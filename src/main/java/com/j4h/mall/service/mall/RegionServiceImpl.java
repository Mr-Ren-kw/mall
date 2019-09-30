package com.j4h.mall.service.mall;

import com.j4h.mall.mapper.mall.RegionMapper;
import com.j4h.mall.model.mall.RegionArea;
import com.j4h.mall.model.mall.RegionCity;
import com.j4h.mall.model.mall.RegionProvince;
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
        List<RegionProvince> regionProvinceList = regionMapper.getRegionProvinceList();
        // 对每个省份中的城市进行封装
        for (RegionProvince regionProvince : regionProvinceList) {
            // 取出id进行查询
            int pid = regionProvince.getId();
            List<RegionCity> regionCities = regionMapper.getRegionCityListByPid(pid);
            // 对每个城市中的区域进行封装
            for (RegionCity regionCity : regionCities) {
                int cid = regionCity.getId();
                List<RegionArea> regionAreas = regionMapper.getRegionAreaListByCid(cid);
                regionCity.setChildren(regionAreas);
            }
            regionProvince.setChildren(regionCities);
        }
        return regionProvinceList;
    }
}
