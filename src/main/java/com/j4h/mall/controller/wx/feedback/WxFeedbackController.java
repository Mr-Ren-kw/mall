package com.j4h.mall.controller.wx.feedback;

import com.j4h.mall.model.wx.feedback.FeedBack;
import com.j4h.mall.service.wx.feedback.WxFeedbackService;
import com.j4h.mall.vo.BaseRespVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wx/feedback")
public class WxFeedbackController {

    @Autowired
    WxFeedbackService wxFeedbackService;

    @RequestMapping("submit")
    public BaseRespVo submitFeedBack(@RequestBody FeedBack feedBack) {
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        if(userId == null) {
            return BaseRespVo.fail(501, "请登录");
        }
        wxFeedbackService.feedback(userId, feedBack);
        return BaseRespVo.ok(null);
    }
}
