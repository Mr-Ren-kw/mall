package com.j4h.mall.service.extension.groupon;

import com.j4h.mall.model.extension.groupon.BeanForDatabase.GrouponRules;
import com.j4h.mall.vo.extension.BeanForData.PageData;
import com.j4h.mall.vo.extension.BeanForRequest.GrouponPageRequest;
import com.j4h.mall.vo.extension.BeanForRequest.GrouponRulesPageRequest;

public interface GrouponService {
    PageData queryGrouponRulesByPage(GrouponRulesPageRequest grouponRulesPageRequest);

    GrouponRules addGrouponRules(GrouponRules grouponRules);

    void updateGrouponRules(GrouponRules grouponRules);

    void deleteGrouponRulesById(int rulesId);

    PageData queryGrouponByPage(GrouponPageRequest grouponPageRequest);
}
