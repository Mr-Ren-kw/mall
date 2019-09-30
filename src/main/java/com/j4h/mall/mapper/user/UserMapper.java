package com.j4h.mall.mapper.user;

import com.j4h.mall.model.user.Address;
import com.j4h.mall.model.user.User;
import com.j4h.mall.vo.user.MyPageHelper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {


    List<User> queryUsers(@Param("myPageHelper") MyPageHelper myPageHelper);

    List<Address> queryAddressList(@Param("myPageHelper")MyPageHelper myPageHelper);

    String queryRegionNameById(@Param("id")int areaId);
}
