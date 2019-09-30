package com.j4h.mall.service.mall;

import com.j4h.mall.model.PageBean;
import com.j4h.mall.model.mall.Brand;
import com.j4h.mall.vo.mall.BrandCreateVo;

public interface BrandService {
    PageBean<Brand> brandList(int page,int limit,String sort,String order,Integer id,String name);

    Brand brandCreate(BrandCreateVo brandCreateVo);

    Brand brandUpdate(Brand brand);
}
