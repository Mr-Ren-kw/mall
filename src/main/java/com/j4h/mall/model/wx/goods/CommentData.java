package com.j4h.mall.model.wx.goods;

import com.j4h.mall.model.goods.GoodsComment;

import java.util.List;

public class CommentData {
    private int count;
    private List<GoodsComment> data;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<GoodsComment> getData() {
        return data;
    }

    public void setData(List<GoodsComment> data) {
        this.data = data;
    }
}
