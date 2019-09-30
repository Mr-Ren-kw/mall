package com.j4h.mall.controller.systemManage;

import com.j4h.mall.model.systemBean.AdminList;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.model.systemBean.AdminOfSystemManage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin/admin")
public class AdminAdminController {
    /**
     * 分页显示管理员帐号
     * @param page 第几页
     * @param limit 一页显示几条
     * @param sort 排序的方法
     * @param order 升序还是降序
     * @return BaseRespVo
     */
    @RequestMapping("/list")
    public BaseRespVo showAdminList(int page, int limit, String sort, String order){

        AdminOfSystemManage adminOfSystemManage = new AdminOfSystemManage();
        AdminList adminList = new AdminList();
        return BaseRespVo.ok(adminList);
    }
}
