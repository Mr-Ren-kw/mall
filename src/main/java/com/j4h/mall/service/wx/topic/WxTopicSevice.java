package com.j4h.mall.service.wx.topic;

import com.j4h.mall.model.extension.topic.BeanForDatabase.Topic;
import com.j4h.mall.model.wx.topic.WxTopicDetailVo;
import com.j4h.mall.model.wx.topic.WxTopicVo;
import net.sf.jsqlparser.statement.select.Top;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/5 16:31
 */
public interface WxTopicSevice {
    WxTopicVo getTopicList(int page, int size);
    WxTopicDetailVo getTopicDetail(int id);
    List<Topic> getRelatedTopic(int id);
}
