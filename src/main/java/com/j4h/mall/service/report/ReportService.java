package com.j4h.mall.service.report;

import com.j4h.mall.model.report.ReportGoods;
import com.j4h.mall.model.report.ReportOrder;
import com.j4h.mall.model.report.ReportUser;

public interface ReportService {
    ReportUser[] getUserRows();

    ReportOrder[] getOrderRows();

    ReportGoods[] getGoodsRows();
}
