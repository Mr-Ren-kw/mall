package com.j4h.mall.service.wx.address;

import com.j4h.mall.mapper.address.AddressMapper;
import com.j4h.mall.mapper.mall.RegionMapper;
import com.j4h.mall.model.wx.address.WxAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WxAddressServiceImpl implements WxAddressService {
    @Autowired
    AddressMapper addressMapper;

    @Autowired
    RegionMapper regionMapper;

    @Override
    public List<WxAddress> getAddressListByUserId(int userId) {
        List<WxAddress> addressListByUserId = addressMapper.getAddressListByUserId(userId);
        for (WxAddress wxAddress : addressListByUserId) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(regionMapper.queryRegionNameById(wxAddress.getProvinceId()));
            stringBuilder.append(regionMapper.queryRegionNameById(wxAddress.getCityId()));
            stringBuilder.append(regionMapper.queryRegionNameById(wxAddress.getAreaId()));
            wxAddress.setDetailedAddress(stringBuilder.toString() + " " + wxAddress.getDetailedAddress());
        }
        return addressListByUserId;
    }
}
