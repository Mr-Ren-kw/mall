package com.j4h.mall.service.wx.topic;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.extension.TopicMapper;
import com.j4h.mall.model.extension.topic.BeanForDatabase.Topic;
import com.j4h.mall.model.wx.topic.WxTopicDetailVo;
import com.j4h.mall.model.wx.topic.WxTopicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/5 16:31
 */
@Service
public class WxTopicServiceImpl implements WxTopicSevice{
    @Autowired
    TopicMapper topicMapper;

    @Override
    public WxTopicVo getTopicList(int page, int size) {
        PageHelper.startPage(page, size);
        String title = null;
        String subtitle = null;
        List<Topic> topics = topicMapper.queryTopicByCondition(title,subtitle);
        PageInfo<Topic> topicPageInfo = new PageInfo<>(topics);
        long total = topicPageInfo.getTotal();
        WxTopicVo wxTopicVo = new WxTopicVo();
        wxTopicVo.setData(topics);
        wxTopicVo.setCount(total);
        return wxTopicVo;
    }

    @Override
    public WxTopicDetailVo getTopicDetail(int id) {
        Topic topic = topicMapper.queryTopicById(id);
        WxTopicDetailVo wxTopicDetailVo = new WxTopicDetailVo();
        wxTopicDetailVo.setTopic(topic);
        String[] goods = topic.getGoods();
        wxTopicDetailVo.setGoods(goods);
        return wxTopicDetailVo;
    }

    @Override
    public List<Topic> getRelatedTopic(int id) {
        // 先取出id最大的那条的ID值
        int maxId = topicMapper.queryMaxId();
        List<Topic> topicList = new ArrayList<>();
        int count = 0;
        int i = id;
        while (count < 4){
            i = (i + 1) % maxId;
            Topic topic = topicMapper.queryTopicById(i);
            if (topic != null){
                topicList.add(topic);
                count++;
            }
        }
        return topicList;
    }
}
