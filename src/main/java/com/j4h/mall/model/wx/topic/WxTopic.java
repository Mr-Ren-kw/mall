package com.j4h.mall.model.wx.topic;

/**
 * 好像重复建了，先不用
 * @author sld
 * @version 1.0
 * @date 2019/10/5 16:24
 */
public class WxTopic {

    /**
     * picUrl : http://192.168.2.100:8081/wx/storage/fetch/1a6oziknmom5ktxsljmj.jpg
     * price : 6.6666666E7
     * subtitle : E往无前
     * id : 362
     * title : 星之守护者---石小刚---至臻
     * readCount : 99999999
     */
    private int id;
    private String title;
    private String subtitle;
    private double price;
    private String readCount;
    private String picUrl;

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReadCount(String readCount) {
        this.readCount = readCount;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public double getPrice() {
        return price;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getReadCount() {
        return readCount;
    }
}
