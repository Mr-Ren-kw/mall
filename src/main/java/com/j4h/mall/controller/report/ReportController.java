package com.j4h.mall.controller.report;

import com.j4h.mall.model.report.*;
import com.j4h.mall.service.report.ReportService;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/stat")
public class ReportController {

    @Autowired
    ReportService reportService;

    //获得用户的统计信息
    @RequestMapping("user")
    public BaseRespVo getUserMsg(){

        String[] columns = {"day","users"};
        ReportUser[] rows = reportService.getUserRows();
        ReportUserData reportDate = new ReportUserData();
        reportDate.setColumns(columns);
        reportDate.setRows(rows);
        return BaseRespVo.ok(reportDate);
    }

    @RequestMapping("order")
    public BaseRespVo getOrderMsg(){

        String[] columns = {"day","orders","customers","amount","pcr"};
        ReportOrder[] rows = reportService.getOrderRows();
        ReportOrderData reportDate = new ReportOrderData();
        reportDate.setColumns(columns);
        reportDate.setRows(rows);
        return BaseRespVo.ok(reportDate);
    }

@RequestMapping("goods")
    public BaseRespVo getGoodsMsg(){

        String[] columns = {"day","orders","products","amount"};
        ReportGoods[] rows = reportService.getGoodsRows();
        ReportGoodsData reportDate = new ReportGoodsData();
        reportDate.setColumns(columns);
        reportDate.setRows(rows);
        return BaseRespVo.ok(reportDate);
    }

}
