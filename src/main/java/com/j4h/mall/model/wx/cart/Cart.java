package com.j4h.mall.model.wx.cart;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class Cart {

    /**
     * productId : 414
     * addTime : 2019-10-04 12:08:48
     * goodsId : 1181064
     * goodsSn : 12345
     * updateTime : 2019-10-04 12:09:29
     * userId : 1
     * specifications : ["规格值","规格值2"]
     * number : 5
     * picUrl : http://192.168.2.100:8081/wx/storage/fetch/kgf66d64ha7riei5ibxs.jpg
     * deleted : false
     * price : 33.0
     * checked : true
     * id : 482
     * goodsName : 商品名称
     */
    private int productId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date addTime;
    private int goodsId;
    private String goodsSn;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    private int userId;
    private String[] specifications;
    private int number;
    private String picUrl;
    private boolean deleted;
    private double price;
    private boolean checked;
    private int id;
    private String goodsName;

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setSpecifications(String[] specifications) {
        this.specifications = specifications;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getProductId() {
        return productId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public int getUserId() {
        return userId;
    }

    public String[] getSpecifications() {
        return specifications;
    }

    public int getNumber() {
        return number;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public double getPrice() {
        return price;
    }

    public boolean getChecked() {
        return checked;
    }

    public int getId() {
        return id;
    }

    public String getGoodsName() {
        return goodsName;
    }
}
