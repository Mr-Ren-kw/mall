package com.j4h.mall.mapper.comment;

import com.j4h.mall.model.wx.order.OrderComment;
import org.apache.ibatis.annotations.Param;

public interface WxComment {

    void commentOrder(@Param("uid") Integer userId, @Param("comment") OrderComment orderComment);
}
