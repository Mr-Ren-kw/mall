package com.j4h.mall.model.wx.topic;

import com.j4h.mall.model.extension.topic.BeanForDatabase.Topic;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/5 17:02
 */
public class WxTopicVo {
    long count;
    List<Topic> data;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<Topic> getData() {
        return data;
    }

    public void setData(List<Topic> data) {
        this.data = data;
    }
}
