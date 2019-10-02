package com.j4h.mall.model.extension.ad.BeanForDatabase;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Advertise {
    private boolean deleted;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date addTime;
    private String link;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    private int id;
    private int position;
    private String content;
    private boolean enabled;
    private String url;

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Date getAddTime() {
        return addTime;
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public int getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public String getContent() {
        return content;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getUrl() {
        return url;
    }
}
