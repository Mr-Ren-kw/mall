package com.j4h.mall.service.wx.address;

import com.j4h.mall.model.wx.address.WxAddress;
import com.j4h.mall.model.wx.address.WxAddressDetail;

import java.util.List;

public interface WxAddressService {
    List<WxAddress> getAddressListByUserId(int userId);

    WxAddressDetail getAddressDetailById(int id);

    int updateAddressById(WxAddressDetail wxAddressDetail);

    int insertNewAddress(WxAddressDetail wxAddressDetail,int userId);
}
