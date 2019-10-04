package com.j4h.mall.service.extension.topic;

import com.j4h.mall.model.extension.topic.BeanForDatabase.Topic;
import com.j4h.mall.vo.extension.BeanForData.PageData;
import com.j4h.mall.vo.extension.BeanForRequest.TopicPageRequest;

public interface TopicService {
    PageData queryTopicByPage(TopicPageRequest topicPageRequest);

    Topic addTopic(Topic topic);

    Topic updateTopic(Topic topic);

    void deleteTopicById(int id);
}
