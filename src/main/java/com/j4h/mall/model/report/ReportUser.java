package com.j4h.mall.model.report;

public class ReportUser {

    String day;
    int users;

    @Override
    public String toString() {
        return "ReportUser{" +
                "day='" + day + '\'' +
                ", users=" + users +
                '}';
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }
}
