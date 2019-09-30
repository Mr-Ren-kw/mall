package com.j4h.mall.controller.mall;

import com.j4h.mall.service.mall.BrandService;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping(value = "/admin/brand/list",params = {"page","limit","sort","order"})
    public BaseRespVo brandList(int page,int limit,String sort,String order) {
        return BaseRespVo.ok(brandService.brandList(page,limit,sort,order));
    }
}
