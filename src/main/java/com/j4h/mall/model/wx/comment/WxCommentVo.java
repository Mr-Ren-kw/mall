package com.j4h.mall.model.wx.comment;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/5 20:01
 */
public class WxCommentVo {
    private long count;
    private int currentPage;
    private List<WxCommentAndUserInfo> data;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<WxCommentAndUserInfo> getData() {
        return data;
    }

    public void setData(List<WxCommentAndUserInfo> data) {
        this.data = data;
    }
}
