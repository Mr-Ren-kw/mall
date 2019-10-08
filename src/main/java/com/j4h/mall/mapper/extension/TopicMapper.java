package com.j4h.mall.mapper.extension;

import com.j4h.mall.model.extension.topic.BeanForDatabase.Topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopicMapper {
    List<Topic> queryTopicByCondition(@Param("title") String title, @Param("subtitle") String subtitle);

    void insertTopic(@Param("topic") Topic topic);

    Topic queryTopicById(@Param("id") int topicId);

    void updateTopic(@Param("topic") Topic topic);

    void deleteTopicById(int topicId);

    int queryMaxId();
}
