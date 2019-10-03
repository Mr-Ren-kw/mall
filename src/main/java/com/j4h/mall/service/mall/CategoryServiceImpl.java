package com.j4h.mall.service.mall;

import com.j4h.mall.mapper.mall.CategoryMapper;
import com.j4h.mall.model.mall.category.L1Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.j4h.mall.model.mall.category.L1Name;

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
