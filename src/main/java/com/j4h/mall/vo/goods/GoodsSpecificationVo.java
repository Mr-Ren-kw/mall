package com.j4h.mall.vo.goods;

public class GoodsSpecificationVo {

    /**
     * picUrl :
     * specification : 规格
     * value : 标准
     */
    private String picUrl;
    private String specification;
    private String value;

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public String getSpecification() {
        return specification;
    }

    public String getValue() {
        return value;
    }
}
