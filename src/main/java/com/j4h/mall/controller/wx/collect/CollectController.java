package com.j4h.mall.controller.wx.collect;


import com.github.pagehelper.PageHelper;
import com.j4h.mall.model.wx.collect.Collect;
import com.j4h.mall.model.wx.collect.CollectInfo;
import com.j4h.mall.model.wx.collect.CollectPageBean;
import com.j4h.mall.model.wx.collect.CollectType;
import com.j4h.mall.service.wx.collect.CollectService;
import com.j4h.mall.vo.BaseRespVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("wx/collect")
public class CollectController {

    @Autowired
    CollectService collectService;

    @RequestMapping("addordelete")
    public BaseRespVo<CollectType> addOrDelete(@RequestBody Collect collect) {
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        if(userId == null) {
            return BaseRespVo.fail(501, "请登录");
        }
        CollectType collectType = collectService.addOrDeleteCollect(userId, collect);
        return BaseRespVo.ok(collectType);
    }

    @RequestMapping("list")
    public BaseRespVo<CollectPageBean> listCollect(int type, int page, int size) {
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        if(userId == null) {
            return BaseRespVo.fail(501, "请登录");
        }
        CollectPageBean collectPageBean = collectService.getCollectList(userId, type, page, size);
        return BaseRespVo.ok(collectPageBean);
    }
}
