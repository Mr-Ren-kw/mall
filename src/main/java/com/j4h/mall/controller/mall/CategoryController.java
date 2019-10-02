package com.j4h.mall.controller.mall;

import com.j4h.mall.model.mall.category.L1Category;
import com.j4h.mall.model.mall.category.L1Name;
import com.j4h.mall.service.mall.CategoryService;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
