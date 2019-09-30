package com.j4h.mall.service.mall;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.mall.BrandMapper;
import com.j4h.mall.model.PageBean;
import com.j4h.mall.model.mall.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandMapper brandMapper;

    @Override
    public PageBean<Brand> brandList(int page,int limit, String sort,String order) {
        // 分页逻辑
        PageHelper.startPage(page, limit,sort + " " + order);
        List<Brand> brandList = brandMapper.brandList();
        PageInfo<Brand> brandPageInfo = new PageInfo<>(brandList);
        long total = brandPageInfo.getTotal();
        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setItems(brandList);
        brandPageBean.setTotal(total);
        return brandPageBean;
    }
}
