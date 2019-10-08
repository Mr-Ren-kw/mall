package com.j4h.mall.service.wx.footprint;

import com.j4h.mall.model.wx.footprint.FootprintDataBean;

public interface WxFootprintService {
    FootprintDataBean getFootprintList(int page, int size, Integer userId);
}
