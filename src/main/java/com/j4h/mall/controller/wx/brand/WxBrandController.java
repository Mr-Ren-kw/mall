package com.j4h.mall.controller.wx.brand;

import com.j4h.mall.model.wx.brand.BrandInfo;
import com.j4h.mall.model.wx.brand.BrandPage;
import com.j4h.mall.service.wx.brand.WxBrandService;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/brand")
public class WxBrandController {

    @Autowired
    WxBrandService brandService;

    @RequestMapping("/list")
    public BaseRespVo queryBrands(int page, int size, Integer brandId) {
        BrandPage brandPage = brandService.queryBrandByPage(page, size, brandId);
        return BaseRespVo.ok(brandPage);
    }
    @GetMapping("/detail")
    public BaseRespVo queryBrandInfo(int id) {
        BrandInfo brandInfo = brandService.queryBrandById(id);
        return BaseRespVo.ok(brandInfo);
    }
}
