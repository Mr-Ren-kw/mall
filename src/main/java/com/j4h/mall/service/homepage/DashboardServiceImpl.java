package com.j4h.mall.service.homepage;

import com.j4h.mall.mapper.homepage.DashboardMapper;
import com.j4h.mall.model.homepage.TotalCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    DashboardMapper dashboardMapper;
    @Override
    public TotalCount dashboard() {
        TotalCount totalCount = new TotalCount();
        totalCount.setGoodsTotal(dashboardMapper.getGoodsTotal());
        totalCount.setOrderTotal(dashboardMapper.getOrderTotal());
        totalCount.setProductTotal(dashboardMapper.getProductTotal());
        totalCount.setUserTotal(dashboardMapper.getUserTotal());
        return totalCount;
    }
}
