package com.j4h.mall.mapper.extension;

import com.j4h.mall.model.wx.comment.WxCommentAndUserInfo;
import com.j4h.mall.model.wx.comment.WxCommentCount;
import com.j4h.mall.model.wx.comment.WxCommentPostRequest;
import com.j4h.mall.model.wx.comment.WxCommentPostResponse;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/5 21:11
 */
public interface CommentOfTopicMapper {
    List<WxCommentAndUserInfo> queryCommentByValueIdAndType(int valueId, int type);
    int countAllByValueIdAndType(int valueId, int type);
    int countHasPicByValueIdAndType(int valueId, int type);
    int insertComment(WxCommentPostRequest wxCommentPostRequest);
    WxCommentPostResponse queryCommentById(int id);
}
