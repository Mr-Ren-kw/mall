package com.j4h.mall.service.wx.feedback;

import com.j4h.mall.mapper.feedback.FeedbackMapper;
import com.j4h.mall.mapper.user.UserMapper;
import com.j4h.mall.model.user.OrderUser;
import com.j4h.mall.model.wx.feedback.FeedBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class WxFeedbackServiceImpl implements WxFeedbackService {
    @Autowired
    FeedbackMapper feedbackMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public void feedback(Integer userId, FeedBack feedBack) {
        String username = userMapper.getUsernameById(userId);
        feedbackMapper.insertFeedback(userId, username, feedBack);
    }
}
