package com.j4h.mall.service.mall;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.mall.BrandMapper;
import com.j4h.mall.model.PageBean;
import com.j4h.mall.model.mall.Brand;
import com.j4h.mall.vo.mall.BrandCreateVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandMapper brandMapper;

    @Override
    public PageBean<Brand> brandList(int page,int limit, String sort,String order,Integer id,String name) {
        // 分页逻辑
        PageHelper.startPage(page, limit,sort + " " + order);
        if (name != null && !"".equals(name)){
            name = "%" + name + "%";
        }
        List<Brand> brandList = brandMapper.brandList(id,name);
        PageInfo<Brand> brandPageInfo = new PageInfo<>(brandList);
        long total = brandPageInfo.getTotal();
        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setItems(brandList);
        brandPageBean.setTotal(total);
        return brandPageBean;
    }

    @Override
    public Brand brandCreate(BrandCreateVo brandCreateVo) {
        Brand brand = new Brand();
        brand.setDesc(brandCreateVo.getDesc());
        brand.setName(brandCreateVo.getName());
        brand.setPicUrl(brandCreateVo.getPicUrl());
        brand.setFloorPrice(Double.parseDouble(brandCreateVo.getFloorPrice()));
        brand = brandMapper.brandCreate(brand);
        return brandMapper.brandSearchById(brand.getId());
    }

    @Override
    public Brand brandUpdate(Brand brand) {
        brandMapper.brandUpdate(brand);
        return brandMapper.brandSearchById(brand.getId());
    }

    @Override
    public int brandDelete(Brand brand) {
        return brandMapper.brandDelete(brand.getId());
    }
}
