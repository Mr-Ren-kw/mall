package com.j4h.mall.controller.reports;

import com.j4h.mall.model.reports.Stat;
import com.j4h.mall.service.reports.StatService;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatController {


    @Autowired
    StatService statService;
    @RequestMapping("admin/stat/user")
    public BaseRespVo statUser(){
        Stat statUser = statService.statUser();
        BaseRespVo<Stat> ok = BaseRespVo.ok(statUser);
        return ok;
    }

    @RequestMapping("admin/stat/order")
    public BaseRespVo statOrder(){
        Stat statUser = statService.statOrder();
        BaseRespVo<Stat> ok = BaseRespVo.ok(statUser);
        return ok;
    }

    @RequestMapping("admin/stat/goods")
    public BaseRespVo statGoodes(){
        Stat statGoodes = statService.statGoodes();
        BaseRespVo<Stat> ok = BaseRespVo.ok(statGoodes);
        return ok;
    }
}
