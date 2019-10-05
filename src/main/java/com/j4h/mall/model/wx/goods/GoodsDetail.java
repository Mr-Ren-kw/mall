package com.j4h.mall.model.wx.goods;

import com.j4h.mall.model.extension.groupon.BeanForDatabase.Groupon;
import com.j4h.mall.model.goods.Goods;
import com.j4h.mall.model.goods.GoodsAttribute;
import com.j4h.mall.model.goods.GoodsProduct;
import com.j4h.mall.model.mall.brand.Brand;
import com.j4h.mall.model.mall.issue.Issue;
import java.util.List;

public class GoodsDetail {
    private List<GoodsAttribute> attributeList;
    private Brand brand;
    private CommentData comment;
    private List<Groupon> groupon;
    private Goods info;
    private List<Issue> issue;
    private List<GoodsProduct> productList;
    private List<SpecificationItem> specificationList;
    private int userHasCollect;

    public List<GoodsAttribute> getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(List<GoodsAttribute> attributeList) {
        this.attributeList = attributeList;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public CommentData getComment() {
        return comment;
    }

    public void setComment(CommentData comment) {
        this.comment = comment;
    }

    public List<Groupon> getGroupon() {
        return groupon;
    }

    public void setGroupon(List<Groupon> groupon) {
        this.groupon = groupon;
    }

    public Goods getInfo() {
        return info;
    }

    public void setInfo(Goods info) {
        this.info = info;
    }

    public List<Issue> getIssue() {
        return issue;
    }

    public void setIssue(List<Issue> issue) {
        this.issue = issue;
    }

    public List<GoodsProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<GoodsProduct> productList) {
        this.productList = productList;
    }

    public List<SpecificationItem> getSpecificationList() {
        return specificationList;
    }

    public void setSpecificationList(List<SpecificationItem> specificationList) {
        this.specificationList = specificationList;
    }

    public int getUserHasCollect() {
        return userHasCollect;
    }

    public void setUserHasCollect(int userHasCollect) {
        this.userHasCollect = userHasCollect;
    }
}
