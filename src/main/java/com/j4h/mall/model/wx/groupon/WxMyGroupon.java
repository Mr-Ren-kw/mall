package com.j4h.mall.model.wx.groupon;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class WxMyGroupon {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date addTime;
    int creatorUserId;
    boolean deleted;
    int grouponId;
    int id;
    int orderId;
    boolean payed;
    int rulesId;
    String shareUrl;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date updateTime;
    int userId;

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

    public int getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(int creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getGrouponId() {
        return grouponId;
    }

    public void setGrouponId(int grouponId) {
        this.grouponId = grouponId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public int getRulesId() {
        return rulesId;
    }

    public void setRulesId(int rulesId) {
        this.rulesId = rulesId;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
