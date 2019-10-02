package com.j4h.mall.controller.mall;

import com.j4h.mall.service.mall.RegionService;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegionController {
    @Autowired
    RegionService regionService;

    @GetMapping("/admin/region/list")
    public BaseRespVo regionList() {
        return BaseRespVo.ok(regionService.regionList());
    }
}
