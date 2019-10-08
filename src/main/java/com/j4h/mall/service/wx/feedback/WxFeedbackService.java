package com.j4h.mall.service.wx.feedback;

import com.j4h.mall.model.wx.feedback.FeedBack;

public interface WxFeedbackService {


    void feedback(Integer userId, FeedBack feedBack);


}
