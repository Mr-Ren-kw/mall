package com.j4h.mall.service.wx.groupon;

import com.j4h.mall.model.wx.groupon.WxGrouponPageBean;
import com.j4h.mall.model.wx.groupon.WxGrouponRequestBean;

public interface WxGrouponService {
    WxGrouponPageBean queryGroupon(WxGrouponRequestBean wxGrouponRequestBean);

    WxGrouponPageBean getMyGroupon(int userId, boolean isCreator);

    WxGrouponPageBean getMyJoinGroupOn(int userId, boolean isCreator);
}
