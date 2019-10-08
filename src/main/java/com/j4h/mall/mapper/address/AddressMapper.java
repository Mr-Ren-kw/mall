package com.j4h.mall.mapper.address;

import com.j4h.mall.model.wx.address.WxAddress;
import com.j4h.mall.model.wx.address.WxAddressDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {

    List<WxAddress> getAddressListByUserId(@Param("userId")int userId);

    WxAddressDetail getAddressDetailById(@Param("id") int id);

    int updateAddressById(@Param("new") WxAddressDetail wxAddressDetail);

    int insertNewAddress(@Param("new") WxAddressDetail wxAddressDetail,@Param("userId") int userId);

    int setOtherAddressNotDefault();

    int deleteAddressById(@Param("id") int id);

    int getUserIdById(@Param("id") int id);
}
