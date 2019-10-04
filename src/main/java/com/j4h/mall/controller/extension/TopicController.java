package com.j4h.mall.controller.extension;

import com.j4h.mall.model.extension.topic.BeanForDatabase.Topic;
import com.j4h.mall.service.extension.topic.TopicService;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.extension.BeanForData.PageData;
import com.j4h.mall.vo.extension.BeanForRequest.TopicPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/topic")
public class TopicController {

    @Autowired
    TopicService topicService;

    @GetMapping("/list")
    public BaseRespVo topicPage(TopicPageRequest topicPageRequest) {
        PageData topicPageData = topicService.queryTopicByPage(topicPageRequest);
        return BaseRespVo.ok(topicPageData);
    }
    @RequestMapping("/update")
    public BaseRespVo updateTopic(@RequestBody Topic topic) {
        topic = topicService.updateTopic(topic);
        return BaseRespVo.ok(topic);
    }
    @RequestMapping("/delete")
    public BaseRespVo deleteTopic(@RequestBody Topic topic) {
        topicService.deleteTopicById(topic.getId());
        return BaseRespVo.ok(null);
    }
    @RequestMapping("/create")
    public BaseRespVo createTopic(@RequestBody Topic topic) {
        Topic topic1 = topicService.addTopic(topic);
        return BaseRespVo.ok(topic1);
    }
}
