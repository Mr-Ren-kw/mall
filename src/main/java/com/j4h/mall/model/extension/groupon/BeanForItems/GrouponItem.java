package com.j4h.mall.model.extension.groupon.BeanForItems;

import com.j4h.mall.model.extension.groupon.BeanForDatabase.Groupon;
import com.j4h.mall.model.extension.groupon.BeanForDatabase.GrouponRules;

public class GrouponItem {
    private Goods goods;
    private Groupon groupon;
    private GrouponRules rules;
    private Groupon[] subGroupons;

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

    public Groupon[] getSubGroupons() {
        return subGroupons;
    }

    public void setSubGroupons(Groupon[] subGroupons) {
        this.subGroupons = subGroupons;
    }
}
