package com.j4h.mall.model.extension.groupon.BeanForItems;

import com.j4h.mall.model.extension.groupon.BeanForDatabase.Groupon;
import com.j4h.mall.model.extension.groupon.BeanForDatabase.GrouponRules;
import com.j4h.mall.model.extension.groupon.BeanForDatabase.GrouponUser;
import com.j4h.mall.model.goods.Goods;

public class GrouponItem {
    private Goods goods;
    private Groupon groupon;
    private GrouponRules rules;
    private GrouponUser[] subGroupons;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Groupon getGroupon() {
        return groupon;
    }

    public void setGroupon(Groupon groupon) {
        this.groupon = groupon;
    }

    public GrouponRules getRules() {
        return rules;
    }

    public void setRules(GrouponRules rules) {
        this.rules = rules;
    }

    public GrouponUser[] getSubGroupons() {
        return subGroupons;
    }

    public void setSubGroupons(GrouponUser[] subGroupons) {
        this.subGroupons = subGroupons;
    }
}
