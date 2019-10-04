package com.j4h.mall.controller.extension;

import com.j4h.mall.model.extension.ad.BeanForDatabase.Advertise;
import com.j4h.mall.model.extension.groupon.BeanForDatabase.GrouponRules;
import com.j4h.mall.service.extension.groupon.GrouponService;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.extension.BeanForData.PageData;
import com.j4h.mall.vo.extension.BeanForRequest.GrouponPageRequest;
import com.j4h.mall.vo.extension.BeanForRequest.GrouponRulesPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/groupon")
public class GrouponController {

    @Autowired
    GrouponService grouponService;

    @GetMapping("/list")
    public BaseRespVo grouponPage(GrouponRulesPageRequest grouponRulesPageRequest) {
        PageData grouponRulesPageData = grouponService.queryGrouponRulesByPage(grouponRulesPageRequest);
        return BaseRespVo.ok(grouponRulesPageData);
    }
    @RequestMapping("/update")
    public BaseRespVo updateAd(@RequestBody GrouponRules grouponRules) {
        grouponService.updateGrouponRules(grouponRules);
        return BaseRespVo.ok(null);
    }
    @RequestMapping("/delete")
    public BaseRespVo deleteAd(@RequestBody GrouponRules grouponRules) {
        grouponService.deleteGrouponRulesById(grouponRules.getId());
        return BaseRespVo.ok(null);
    }
    @RequestMapping("/create")
    public BaseRespVo createGrouponRules(@RequestBody GrouponRules grouponRules) {
        GrouponRules grouponRules1 = grouponService.addGrouponRules(grouponRules);
        return BaseRespVo.ok(grouponRules1);
    }
    @RequestMapping("/listRecord")
    public BaseRespVo queryGrouponsByPage(GrouponPageRequest grouponPageRequest) {
        PageData grouponPageData = grouponService.queryGrouponByPage(grouponPageRequest);
        return BaseRespVo.ok(grouponPageData);
    }
}
