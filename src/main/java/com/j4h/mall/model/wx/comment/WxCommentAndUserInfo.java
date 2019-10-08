package com.j4h.mall.model.wx.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.j4h.mall.model.user.UserInfoForComment;
import com.j4h.mall.util.UserInfo;

import java.util.Date;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/5 20:35
 */
public class WxCommentAndUserInfo {
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
    private String[] picList;
    private int userId;
    private String content;
    UserInfoForComment userInfo;

    public String[] getPicList() {
        return picList;
    }

    public void setPicList(String[] picList) {
        this.picList = picList;
    }

    public boolean isHasPicture() {
        return hasPicture;
    }

    public void setHasPicture(boolean hasPicture) {
        this.hasPicture = hasPicture;
    }

    public int getValueId() {
        return valueId;
    }

    public void setValueId(int valueId) {
        this.valueId = valueId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserInfoForComment getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoForComment userInfo) {
        this.userInfo = userInfo;
    }
}
