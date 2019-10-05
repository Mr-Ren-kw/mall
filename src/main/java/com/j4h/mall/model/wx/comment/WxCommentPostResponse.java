package com.j4h.mall.model.wx.comment;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/5 23:11
 */
public class WxCommentPostResponse {
    int id;
    String content;
    boolean hasPicture;
    String[] picUrls;
    int star;
    int type;
    int valueId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date addTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date updateTime;
    int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isHasPicture() {
        return hasPicture;
    }

    public void setHasPicture(boolean hasPicture) {
        this.hasPicture = hasPicture;
    }

    public String[] getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String[] picUrls) {
        this.picUrls = picUrls;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getValueId() {
        return valueId;
    }

    public void setValueId(int valueId) {
        this.valueId = valueId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
