package com.j4h.mall.service.wx.address;

import com.j4h.mall.model.wx.address.WxAddress;

import java.util.List;

public interface WxAddressService {
    List<WxAddress> getAddressListByUserId(int userId);
}
