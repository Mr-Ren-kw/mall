package com.j4h.mall.model.wx.comment;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/5 20:24
 */
public class WxCommentListRequest {
    int valueId;
    int type;
    int showType;
    int page;
    int size;

    public int getValueId() {
        return valueId;
    }

    public void setValueId(int valueId) {
        this.valueId = valueId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getShowType() {
        return showType;
    }

    public void setShowType(int showType) {
        this.showType = showType;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
