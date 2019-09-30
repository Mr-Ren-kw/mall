package com.j4h.mall.vo.goods;

public class GoodsAttributeVo {

    /**
     * attribute : M
     * value : 30
     */
    private String attribute;
    private String value;

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAttribute() {
        return attribute;
    }

    public String getValue() {
        return value;
    }
}
