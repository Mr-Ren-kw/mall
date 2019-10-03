package com.j4h.mall.model.report;

public class ReportGoodsData {

    String[] columns;
    ReportGoods[] rows;

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public ReportGoods[] getRows() {
        return rows;
    }

    public void setRows(ReportGoods[] rows) {
        this.rows = rows;
    }
}
