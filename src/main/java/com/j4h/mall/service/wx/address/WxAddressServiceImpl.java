package com.j4h.mall.service.wx.address;

import com.j4h.mall.mapper.address.AddressMapper;
import com.j4h.mall.mapper.mall.RegionMapper;
import com.j4h.mall.model.wx.address.WxAddress;
import com.j4h.mall.model.wx.address.WxAddressDetail;
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

    @Override
    public WxAddressDetail getAddressDetailById(int id) {
        WxAddressDetail addressDetailById = addressMapper.getAddressDetailById(id);
        addressDetailById.setProvinceName(regionMapper.queryRegionNameById(addressDetailById.getProvinceId()));
        addressDetailById.setCityName(regionMapper.queryRegionNameById(addressDetailById.getCityId()));
        addressDetailById.setAreaName(regionMapper.queryRegionNameById(addressDetailById.getAreaId()));
        return addressDetailById;
    }

    @Override
    public int updateAddressById(WxAddressDetail wxAddressDetail) {
        if (wxAddressDetail.getIsDefault()) {
            addressMapper.setOtherAddressNotDefault();
        }
        addressMapper.updateAddressById(wxAddressDetail);
        return wxAddressDetail.getId();
    }

    @Override
    public int insertNewAddress(WxAddressDetail wxAddressDetail,int userId) {
        if (wxAddressDetail.getIsDefault()) {
            addressMapper.setOtherAddressNotDefault();
        }
        addressMapper.insertNewAddress(wxAddressDetail,userId);
        return wxAddressDetail.getId();
    }
}
