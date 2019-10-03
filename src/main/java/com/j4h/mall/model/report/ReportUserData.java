package com.j4h.mall.model.report;

public class ReportUserData{
    String[] columns;
    ReportUser[] rows;
    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public ReportUser[] getRows() {
        return rows;
    }

    public void setRows(ReportUser[] rows) {
        this.rows = rows;
    }
}
