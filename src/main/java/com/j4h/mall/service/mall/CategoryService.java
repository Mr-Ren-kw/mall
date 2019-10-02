package com.j4h.mall.service.mall;

import com.j4h.mall.model.mall.category.AddCategory;
import com.j4h.mall.model.mall.category.L1Category;
import com.j4h.mall.model.mall.category.L1Name;
import com.j4h.mall.vo.mall.category.AddCategoryVo;
import com.j4h.mall.vo.mall.category.UpdateCategoryVo;

import java.util.List;

public interface CategoryService {
    List<L1Name> getL1Category();

    List<L1Category> queryAllCategory();

    AddCategory createCategory(AddCategoryVo addCategoryVo);

    int updateCategory(UpdateCategoryVo updateCategoryVo);

    int deleteCategory(UpdateCategoryVo updateCategoryVo);
}
