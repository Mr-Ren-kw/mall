package com.j4h.mall.model.system;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/2 15:24
 */
public class Storage {

    /**
     * size : 304578
     * addTime : 2019-10-02 01:00:18
     * name : 11.jpg
     * updateTime : 2019-10-02 01:00:18
     * id : 981
     * type : image/jpeg
     * key : 8sf4jdlwhiebklmpn5j4.jpg
     * url : http://192.168.2.100:8081/wx/storage/fetch/8sf4jdlwhiebklmpn5j4.jpg
     */
    private int size;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date addTime;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private int id;
    private String type;
    private String key;
    private String url;
    private boolean deleted;

    public Date getAddTime() {
        return addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getKey() {
        return key;
    }

    public String getUrl() {
        return url;
    }
}
