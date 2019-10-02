package com.j4h.mall.model.goods;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;


public class GoodsComment {


    /**
     * hasPicture : true
     * valueId : 1027004
     * deleted : false
     * star : 1
     * addTime : 2018-01-31 19:00:00
     * updateTime : 2018-01-31 19:00:00
     * id : 761
     * type : 0
     * picUrls : ["https://yanxuan.nosdn.127.net/9fcf69c825c9e0d5710e0266b6d40866.jpg"]
     * userId : 1
     * content : 今年爱上纱布，颜色淡雅宜人，柔软又透气。如果有宝宝版就更好了。
     */
    private boolean hasPicture;
    private int valueId;
    private boolean deleted;
    private int star;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date addTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    private int id;
    private int type;
    private String[] picUrls;
    private int userId;
    private String content;

    public void setHasPicture(boolean hasPicture) {
        this.hasPicture = hasPicture;
    }

    public void setValueId(int valueId) {
        this.valueId = valueId;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setPicUrls(String[] picUrls) {
        this.picUrls = picUrls;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isHasPicture() {
        return hasPicture;
    }

    public int getValueId() {
        return valueId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public int getStar() {
        return star;
    }

    public Date getAddTime() {
        return addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public String[] getPicUrls() {
        return picUrls;
    }

    public int getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }
}
