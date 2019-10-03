package com.j4h.mall.service.report;

import com.j4h.mall.mapper.report.ReportMapper;
import com.j4h.mall.model.report.ReportGoods;
import com.j4h.mall.model.report.ReportOrder;
import com.j4h.mall.model.report.ReportUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService{

    @Autowired
    ReportMapper reportMapper;
    @Override
    public ReportUser[] getUserRows() {

        return reportMapper.getUserRows();
    }

    @Override
    public ReportOrder[] getOrderRows() {

        return reportMapper.getOrderRows();
    }

    @Override
    public ReportGoods[] getGoodsRows() {
        return reportMapper.getGoodsRows();
    }
}
