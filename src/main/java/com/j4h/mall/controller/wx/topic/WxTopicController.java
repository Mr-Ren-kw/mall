package com.j4h.mall.controller.wx.topic;

import com.j4h.mall.model.extension.topic.BeanForDatabase.Topic;
import com.j4h.mall.model.wx.topic.WxTopicDetailVo;
import com.j4h.mall.model.wx.topic.WxTopicVo;
import com.j4h.mall.service.wx.topic.WxTopicSevice;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/5 16:29
 */
@RestController
@CrossOrigin
@RequestMapping("/wx/topic")
public class WxTopicController {

    @Autowired
    WxTopicSevice wxTopicSevice;

    @GetMapping("/list")
    public BaseRespVo showTopicList(int page, int size){
        WxTopicVo wxTopicVo = wxTopicSevice.getTopicList(page, size);
        return BaseRespVo.ok(wxTopicVo);
    }

    @GetMapping("/detail")
    public BaseRespVo showTopicDetail(int id){
        WxTopicDetailVo topicDetail = wxTopicSevice.getTopicDetail(id);
        return BaseRespVo.ok(topicDetail);
    }

    /**
     * 专题推荐，返回四个id在其后的topic
     * @param id
     * @return
     */
    @GetMapping("/related")
    public BaseRespVo showRelatedTopic(int id){
        List<Topic> relatedTopic = wxTopicSevice.getRelatedTopic(id);
        return BaseRespVo.ok(relatedTopic);
    }
}
