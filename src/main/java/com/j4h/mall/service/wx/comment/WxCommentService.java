package com.j4h.mall.service.wx.comment;

import com.j4h.mall.model.wx.comment.*;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/5 19:51
 */
public interface WxCommentService {
    WxCommentVo getCommentList(WxCommentListRequest wxCommentListRequest);
    WxCommentCount countCommentList(WxCommentListRequest wxCommentListRequest);
    WxCommentPostResponse addComment(WxCommentPostRequest wxCommentPostRequest);
}
