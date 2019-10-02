package com.j4h.mall.controller.homepage;

import com.j4h.mall.model.homepage.TotalCount;
import com.j4h.mall.service.homepage.DashboardService;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {
    @Autowired
    DashboardService dashboardService;
    @GetMapping("/admin/dashboard")
    public BaseRespVo dashboard() {
        TotalCount totalCount = dashboardService.dashboard();
        return BaseRespVo.ok(totalCount);
    }
}
