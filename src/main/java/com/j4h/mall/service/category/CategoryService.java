package com.j4h.mall.service.category;

import com.j4h.mall.model.category.AddCategory;
import com.j4h.mall.model.category.L1Category;
import com.j4h.mall.model.category.L1Name;
import com.j4h.mall.vo.category.AddCategoryVo;
import com.j4h.mall.vo.category.UpdateCategoryVo;

import java.util.List;

public interface CategoryService {
    List<L1Name> getL1Category();

    List<L1Category> queryAllCategory();

    AddCategory createCategory(AddCategoryVo addCategoryVo);

    int updateCategory(UpdateCategoryVo updateCategoryVo);

    int deleteCategory(UpdateCategoryVo updateCategoryVo);
}
