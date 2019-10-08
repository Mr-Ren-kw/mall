package com.j4h.mall.controller.wx.comment;

import com.j4h.mall.model.wx.comment.*;
import com.j4h.mall.service.wx.comment.WxCommentService;
import com.j4h.mall.util.LoginOrNotUtils;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/5 16:04
 */
@RestController
@CrossOrigin
@RequestMapping("/wx/comment")
public class WxCommentController {
    @Autowired
    WxCommentService wxCommentService;

    @GetMapping("/list")
    public BaseRespVo getCommentList(WxCommentListRequest wxCommentListRequest){
        WxCommentVo commentList = wxCommentService.getCommentList(wxCommentListRequest);
        return BaseRespVo.ok(commentList);
    }

    @GetMapping("/count")
    public BaseRespVo countCommentList(WxCommentListRequest wxCommentListRequest){
        WxCommentCount wxCommentCount = wxCommentService.countCommentList(wxCommentListRequest);
        return BaseRespVo.ok(wxCommentCount);
    }

    /**
     * 发表留言，字数限制140，需要登录才能操作
     * @return
     */
    @PostMapping("/post")
    public BaseRespVo postComment(@RequestBody WxCommentPostRequest wxCommentPostRequest){
        Integer userId = LoginOrNotUtils.getUserId();
        if (userId == null){
            return BaseRespVo.fail(555,"请登录后重试");
        }
        // 加一个登录验证
        String content = wxCommentPostRequest.getContent();
        int length = content.length();
        if (length > 140){
            BaseRespVo baseRespVo = new BaseRespVo();
            baseRespVo.setErrmsg("评论字数不能大于140");
            baseRespVo.setErrno(664);
            return baseRespVo;
        }
        // 查询出userId放进去
        wxCommentPostRequest.setUserId(userId);
        WxCommentPostResponse wxCommentPostResponse = wxCommentService.addComment(wxCommentPostRequest);
        return BaseRespVo.ok(wxCommentPostResponse);
    }
}
