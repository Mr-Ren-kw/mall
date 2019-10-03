package com.j4h.mall.model.report;

public class ReportOrderData {
    String[] columns;
    ReportOrder[] rows;

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public ReportOrder[] getRows() {
        return rows;
    }

    public void setRows(ReportOrder[] rows) {
        this.rows = rows;
    }
}
