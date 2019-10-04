package com.j4h.mall.model.extension.coupon.BeanForDatabase;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class Coupon {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date addTime;
    private int discount;
    private int timeType;
    private String[] goodsValue;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    private int type;
    private int goodsType;
    private int total;
    private boolean deleted;
    private int min;
    private int limit;
    private String name;
    private int days;
    private int id;
    private String tag;
    private String desc;
    private int status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setTimeType(int timeType) {
        this.timeType = timeType;
    }

    public String[] getGoodsValue() {
        return goodsValue;
    }

    public void setGoodsValue(String[] goodsValue) {
        this.goodsValue = goodsValue;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setGoodsType(int goodsType) {
        this.goodsType = goodsType;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDiscount() {
        return discount;
    }

    public int getTimeType() {
        return timeType;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public int getType() {
        return type;
    }

    public int getGoodsType() {
        return goodsType;
    }

    public int getTotal() {
        return total;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public int getMin() {
        return min;
    }

    public int getLimit() {
        return limit;
    }

    public String getName() {
        return name;
    }

    public int getDays() {
        return days;
    }

    public int getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }

    public String getDesc() {
        return desc;
    }

    public int getStatus() {
        return status;
    }
}
