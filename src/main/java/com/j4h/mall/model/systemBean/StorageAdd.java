package com.j4h.mall.model.systemBean;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/2 13:12
 */
public class StorageAdd {

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
    private String addTime;
    private String name;
    private String updateTime;
    private int id;
    private String type;
    private String key;
    private String url;
    private int deleted;

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
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

    public String getAddTime() {
        return addTime;
    }

    public String getName() {
        return name;
    }

    public String getUpdateTime() {
        return updateTime;
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
