package com.j4h.mall.service.wx.comment;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.extension.CommentOfTopicMapper;
import com.j4h.mall.mapper.goods.GoodsMapper;
import com.j4h.mall.mapper.user.UserMapper;
import com.j4h.mall.model.user.OrderUser;
import com.j4h.mall.model.user.UserInfoForComment;
import com.j4h.mall.model.wx.comment.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/5 19:51
 */
@Service
public class WxCommentServiceImpl implements WxCommentService{
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    CommentOfTopicMapper commentOfTopiceMapper;

    @Override
    public WxCommentVo getCommentList(WxCommentListRequest wxCommentListRequest) {
        int start = wxCommentListRequest.getPage();
        int limit = wxCommentListRequest.getSize();
        PageHelper.startPage(start,limit);
        int type = wxCommentListRequest.getType();
        int valueId = wxCommentListRequest.getValueId();
        List<WxCommentAndUserInfo> wxCommentAndUserInfos = commentOfTopiceMapper.queryCommentByValueIdAndType(valueId, type);
        for (WxCommentAndUserInfo w: wxCommentAndUserInfos) {
            int userId = w.getUserId();
            UserInfoForComment userInfoForComment = userMapper.queryUserById2(userId);
            w.setUserInfo(userInfoForComment);
        }
        PageInfo<WxCommentAndUserInfo> wxCommentAndUserInfoPageInfo = new PageInfo<>(wxCommentAndUserInfos);
        long total = wxCommentAndUserInfoPageInfo.getTotal();
        WxCommentVo wxCommentVo = new WxCommentVo();
        wxCommentVo.setCurrentPage(start);
        wxCommentVo.setCount(total);
        wxCommentVo.setData(wxCommentAndUserInfos);
        return wxCommentVo;
    }

    @Override
    public WxCommentCount countCommentList(WxCommentListRequest wxCommentListRequest) {
        int type = wxCommentListRequest.getType();
        int valueId = wxCommentListRequest.getValueId();
        int allCount = commentOfTopiceMapper.countAllByValueIdAndType(valueId, type);
        int hasPic = commentOfTopiceMapper.countHasPicByValueIdAndType(valueId, type);
        WxCommentCount wxCommentCount = new WxCommentCount();
        wxCommentCount.setAllCount(allCount);
        wxCommentCount.setHasPicCount(hasPic);
        return wxCommentCount;
    }

    @Override
    public WxCommentPostResponse addComment(WxCommentPostRequest wxCommentPostRequest) {

        return null;
    }
}
