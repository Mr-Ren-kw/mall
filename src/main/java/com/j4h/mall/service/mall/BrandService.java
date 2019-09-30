package com.j4h.mall.service.mall;

import com.j4h.mall.model.PageBean;
import com.j4h.mall.model.mall.Brand;

public interface BrandService {
    PageBean<Brand> brandList(int page,int limit,String sort,String order);
}
