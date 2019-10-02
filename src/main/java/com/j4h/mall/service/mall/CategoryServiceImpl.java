package com.j4h.mall.service.mall;

import com.j4h.mall.mapper.mall.CategoryMapper;
import com.j4h.mall.model.mall.L1Category;
import com.j4h.mall.model.mall.L1Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<L1Name> getL1Category() {
        return categoryMapper.getL1Category();
    }

    @Override
    public List<L1Category> queryAllCategory() {
        return categoryMapper.queryAllCategory();
    }
}
