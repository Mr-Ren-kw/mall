package com.j4h.mall.service.extension.topic;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.extension.TopicMapper;
import com.j4h.mall.model.extension.topic.BeanForDatabase.Topic;
import com.j4h.mall.vo.extension.BeanForData.PageData;
import com.j4h.mall.vo.extension.BeanForRequest.TopicPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicMapper topicMapper;

    @Override
    public PageData queryTopicByPage(TopicPageRequest topicPageRequest) {
        String title = topicPageRequest.getTitle();
        String subtitle = topicPageRequest.getSubtitle();
        if(title != null) {
            title = "%" + title + "%";
        }
        if(subtitle != null) {
            subtitle = "%" + subtitle + "%";
        }
        PageData topicPageData = new PageData<Topic>();
        String orderBy = topicPageRequest.getSort() + " " + topicPageRequest.getOrder();
        PageHelper.startPage(topicPageRequest.getPage(), topicPageRequest.getLimit(), orderBy);
        List<Topic> topicList = topicMapper.queryTopicByCondition(title,subtitle);
        PageInfo<Topic> topicPageInfo = new PageInfo<>(topicList);
        long total = topicPageInfo.getTotal();
        topicPageData.setItems(topicList);
        topicPageData.setTotal((int)total);
        return topicPageData;
    }

    @Override
    public Topic addTopic(Topic topic) {
        topicMapper.insertTopic(topic);
        return topicMapper.queryTopicById(topic.getId());
    }

    @Override
    public Topic updateTopic(Topic topic) {
        topicMapper.updateTopic(topic);
        return topicMapper.queryTopicById(topic.getId());
    }

    @Override
    public void deleteTopicById(int topicId) {
        topicMapper.deleteTopicById(topicId);
    }
}

