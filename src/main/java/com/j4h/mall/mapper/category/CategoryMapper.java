package com.j4h.mall.mapper.category;

import com.j4h.mall.model.category.L1Category;
import com.j4h.mall.model.category.L1Name;

import java.util.List;

public interface CategoryMapper {
    List<L1Name> getL1Category();

    List<L1Category> queryAllCategory();
}
