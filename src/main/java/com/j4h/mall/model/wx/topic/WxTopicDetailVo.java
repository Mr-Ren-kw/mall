package com.j4h.mall.model.wx.topic;

import com.j4h.mall.model.extension.topic.BeanForDatabase.Topic;
import com.j4h.mall.model.goods.Goods;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/5 17:29
 */
public class WxTopicDetailVo {
    String[] goods;
    Topic topic;

    public String[] getGoods() {
        return goods;
    }

    public void setGoods(String[] goods) {
        this.goods = goods;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
