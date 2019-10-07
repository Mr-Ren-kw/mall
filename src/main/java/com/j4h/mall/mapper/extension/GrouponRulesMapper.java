package com.j4h.mall.mapper.extension;

import com.j4h.mall.model.extension.groupon.BeanForDatabase.GrouponRules;
import com.j4h.mall.model.wx.home.GrouponGoods;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface GrouponRulesMapper {
    List<GrouponRules> queryGrouponRulesByCondition(@Param("goodsId") Integer goodsId);

    void insertGrouponRules(@Param("rules") GrouponRules grouponRules);

    GrouponRules queryGrouponRulesById(@Param("id") Integer rulesId);

    int getGoodsIdById(@Param("rulesId") Integer rulesId);

    void updateGrouponRules(@Param("rules") GrouponRules grouponRules);

    void deleteRulesById(@Param("rulesId") int rulesId);

}
