package com.j4h.mall.controller.wx.groupon;

import com.j4h.mall.model.wx.groupon.WxGrouponDetail;
import com.j4h.mall.model.wx.groupon.WxGrouponPageBean;
import com.j4h.mall.model.wx.groupon.WxGrouponRequestBean;
import com.j4h.mall.service.wx.groupon.WxGrouponService;
import com.j4h.mall.util.LoginOrNotUtils;
import com.j4h.mall.vo.BaseRespVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/groupon")
public class WxGrouponController {

    @Autowired
    WxGrouponService wxGrouponService;

    @RequestMapping("list")
    public BaseRespVo getWxGrouponList(WxGrouponRequestBean wxGrouponRequestBean){
        WxGrouponPageBean pageBean = wxGrouponService.queryGroupon(wxGrouponRequestBean);
        return BaseRespVo.ok(pageBean);
    }

    @RequestMapping("my")
    public BaseRespVo getWxGrouponOfMy(int showType){
        Integer userId = LoginOrNotUtils.getUserId();
        if (userId == null){
            return BaseRespVo.fail(501,"请登入后再访问");
        }
        WxGrouponPageBean pageBean = null;
        boolean isCreator = false;
        if (showType == 0){
            isCreator = true;
            pageBean = wxGrouponService.getMyGroupon(userId,isCreator);
        }else if (showType == 1){
            pageBean = wxGrouponService.getMyJoinGroupOn(userId,isCreator);
        }
        return BaseRespVo.ok(pageBean);
    }

    @RequestMapping("detail")
    public BaseRespVo getWxGrouponDetail(int grouponId) {
        Integer userId = LoginOrNotUtils.getUserId();
        if (userId == null) {
            return BaseRespVo.fail(501, "请登入后再访问");
        }
        WxGrouponDetail data = wxGrouponService.getWxGrouponDetail(grouponId);

        return BaseRespVo.ok(data);
    }

}
