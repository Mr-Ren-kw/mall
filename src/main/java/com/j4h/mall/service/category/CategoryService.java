package com.j4h.mall.service.category;

import com.j4h.mall.model.category.L1Category;
import com.j4h.mall.model.category.L1Name;

import java.util.List;

public interface CategoryService {
    List<L1Name> getL1Category();

    List<L1Category> queryAllCategory();
}
