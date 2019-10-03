package com.j4h.mall.model.report;

import java.util.Date;

public class ReportOrder {
    int amount;
    int customers;

    String day;
    int orders;
    int pcr;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public int getPcr() {
        return pcr;
    }

    public void setPcr(int pcr) {
        this.pcr = pcr;
    }
}
