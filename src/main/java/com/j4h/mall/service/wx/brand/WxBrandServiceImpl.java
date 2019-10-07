package com.j4h.mall.service.wx.brand;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.mall.BrandMapper;
import com.j4h.mall.model.mall.brand.Brand;
import com.j4h.mall.model.wx.brand.BrandInfo;
import com.j4h.mall.model.wx.brand.BrandPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxBrandServiceImpl implements WxBrandService{

    @Autowired
    BrandMapper brandMapper;

    @Override
    public BrandPage queryBrandByPage(int page, int size) {
        BrandPage brandPage = new BrandPage();
        PageHelper.startPage(page, size);
        List<Brand> brands = brandMapper.brandList(null,null);
        PageInfo<Brand> brandPageInfo = new PageInfo<>(brands);
        int total = (int) brandPageInfo.getTotal();
        brandPage.setBrandList(brands);
        brandPage.setTotalPages(total/size + 1);
        return brandPage;
    }

    @Override
    public BrandInfo queryBrandById(int brandId) {
        BrandInfo brandInfo = new BrandInfo();
        Brand brand = brandMapper.brandSearchById(brandId);
        brandInfo.setBrand(brand);
        return brandInfo;
    }
}
