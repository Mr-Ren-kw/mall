package com.j4h.mall.mapper.mall;

import com.j4h.mall.model.mall.category.L1Name;
import com.j4h.mall.model.mall.category.L1Category;

import java.util.List;

public interface CategoryMapper {
    List<L1Name> getL1Category();

    List<L1Category> queryAllCategory();
}
