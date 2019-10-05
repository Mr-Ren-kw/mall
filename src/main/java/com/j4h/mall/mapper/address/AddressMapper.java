package com.j4h.mall.mapper.address;

import com.j4h.mall.model.wx.address.WxAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {

    List<WxAddress> getAddressListByUserId(@Param("userId")int userId);
}
