package com.j4h.mall.controller.wx.groupon;

import com.j4h.mall.model.wx.groupon.WxGrouponPageBean;
import com.j4h.mall.model.wx.groupon.WxGrouponRequestBean;
import com.j4h.mall.service.wx.groupon.WxGrouponService;
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
        wxGrouponRequestBean.setSort("add_time");
        wxGrouponRequestBean.setOrder("desc");
        WxGrouponPageBean pageBean = wxGrouponService.queryGroupon(wxGrouponRequestBean);
        return BaseRespVo.ok(pageBean);
    }

    @RequestMapping("my")
    public BaseRespVo getWxGrouponOfMy(int showType){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        int userId = (Integer) session.getAttribute("userId");
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

}
