package com.j4h.mall.controller.mall;

import com.j4h.mall.model.mall.category.AddCategory;
import com.j4h.mall.model.mall.category.L1Category;
import com.j4h.mall.model.mall.category.L1Name;
import com.j4h.mall.service.mall.CategoryService;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.mall.category.AddCategoryVo;
import com.j4h.mall.vo.mall.category.UpdateCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/l1")
    public BaseRespVo getL1Category() {
        List<L1Name> l1Names = categoryService.getL1Category();
        return BaseRespVo.ok(l1Names);
    }

    @GetMapping("/list")
    public BaseRespVo queryAllCategory() {
        List<L1Category> categoryList = categoryService.queryAllCategory();
        return BaseRespVo.ok(categoryList);
    }

    @PostMapping("/create")
    public BaseRespVo createCategory(@RequestBody AddCategoryVo addCategoryVo) {
        AddCategory addCategory = categoryService.createCategory(addCategoryVo);
        return BaseRespVo.ok(addCategory);
    }

    @PostMapping("/update")
    public BaseRespVo updateCategory(@RequestBody UpdateCategoryVo updateCategoryVo) {
        int result = categoryService.updateCategory(updateCategoryVo);
        if (result == 1) {
            return BaseRespVo.ok(null);
        }
        else {
            BaseRespVo baseRespVo = new BaseRespVo();
            baseRespVo.setErrmsg("修改失败");
            baseRespVo.setErrno(402);
            return baseRespVo;
        }
    }

    @PostMapping("/delete")
    public BaseRespVo deleteCategory(@RequestBody UpdateCategoryVo updateCategoryVo) {
        int result = categoryService.deleteCategory(updateCategoryVo);
        if (result >= 1) {
            return BaseRespVo.ok(null);
        }
        else {
            BaseRespVo baseRespVo = new BaseRespVo();
            baseRespVo.setErrmsg("删除失败");
            baseRespVo.setErrno(402);
            return baseRespVo;
        }
    }
}
