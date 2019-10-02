package com.j4h.mall.mapper.category;

import com.j4h.mall.model.category.AddCategory;
import com.j4h.mall.model.category.L1Category;
import com.j4h.mall.model.category.L1Name;
import com.j4h.mall.vo.category.AddCategoryVo;
import com.j4h.mall.vo.category.UpdateCategoryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    List<L1Name> getL1Category();

    List<L1Category> queryAllCategory();

    int createCategory(@Param("new") AddCategoryVo addCategoryVo,@Param("result") AddCategory addCategory);

    AddCategory queryCategoryById(@Param("id") int id);

    int updateCategory(@Param("update") UpdateCategoryVo updateCategoryVo);

    int deleteCategoryByPid(@Param("pid") int pid);

    int deleteCategoryById(@Param("id") int id);
}
