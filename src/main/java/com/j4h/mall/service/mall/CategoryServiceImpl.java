package com.j4h.mall.service.mall;

import com.j4h.mall.mapper.mall.CategoryMapper;
import com.j4h.mall.model.mall.category.AddCategory;
import com.j4h.mall.model.mall.category.L1Category;
import com.j4h.mall.model.mall.category.L1Name;
import com.j4h.mall.model.mall.category.L2Category;
import com.j4h.mall.vo.mall.category.AddCategoryVo;
import com.j4h.mall.vo.mall.category.UpdateCategoryVo;
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

    @Override
    public AddCategory createCategory(AddCategoryVo addCategoryVo) {
        // 先添加条目
        AddCategory addCategory = new AddCategory();
        categoryMapper.createCategory(addCategoryVo,addCategory);
        // 再查询条目
        return categoryMapper.queryCategoryById(addCategory.getId());
    }

    @Override
    public int updateCategory(UpdateCategoryVo updateCategoryVo) {
        return categoryMapper.updateCategory(updateCategoryVo);
    }

    @Override
    public int deleteCategory(UpdateCategoryVo updateCategoryVo) {
        // 先删除二级条目
        int i = 0;
        L2Category[] children = updateCategoryVo.getChildren();
        if (children != null && children.length != 0) {
            i += categoryMapper.deleteCategoryByPid(updateCategoryVo.getId());
        }
        // 再删除一级条目
        i += categoryMapper.deleteCategoryById(updateCategoryVo.getId());
        return i;
    }
}
