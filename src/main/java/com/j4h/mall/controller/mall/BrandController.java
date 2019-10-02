package com.j4h.mall.controller.mall;

import com.j4h.mall.model.mall.brand.Brand;
import com.j4h.mall.service.mall.BrandService;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.mall.BrandCreateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @GetMapping(value = "/list",params = {"page","limit","sort","order"})
    public BaseRespVo brandList(int page,int limit,String sort,String order,Integer id,String name) {
        return BaseRespVo.ok(brandService.brandList(page,limit,sort,order,id,name));
    }

    @PostMapping("/create")
    public BaseRespVo brandCreate(@RequestBody BrandCreateVo brandCreateVo) {
        return BaseRespVo.ok(brandService.brandCreate(brandCreateVo));
    }

    @PostMapping("/update")
    public BaseRespVo brandUpdate(@RequestBody Brand brand) {
        return BaseRespVo.ok(brandService.brandUpdate(brand));
    }

    @PostMapping("/delete")
    public BaseRespVo brandDelete(@RequestBody Brand brand){
        int result = brandService.brandDelete(brand);
        if (result == 1) {
            return BaseRespVo.ok(null);
        } else {
            BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
            baseRespVo.setErrno(100);
            baseRespVo.setData(null);
            baseRespVo.setErrmsg("删除失败，请确认该品牌商是否存在");
            return baseRespVo;
        }
    }
}
