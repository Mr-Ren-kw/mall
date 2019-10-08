package com.j4h.mall.mapper.feedback;

import com.j4h.mall.model.wx.feedback.FeedBack;
import org.apache.ibatis.annotations.Param;

public interface FeedbackMapper {

    void insertFeedback(@Param("uid") Integer userId,@Param("username") String username, @Param("feedback") FeedBack feedBack);

}
