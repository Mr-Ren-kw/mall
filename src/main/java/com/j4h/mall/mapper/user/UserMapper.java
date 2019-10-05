package com.j4h.mall.mapper.user;

import com.j4h.mall.model.user.*;
import com.j4h.mall.util.UserInfo;
import com.j4h.mall.vo.user.MyPageHelper;
import com.j4h.mall.vo.wx.RegisterVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {


    List<User> queryUsers(@Param("myPageHelper") MyPageHelper myPageHelper);

    List<Address> queryAddressList(@Param("myPageHelper")MyPageHelper myPageHelper);

    List<Collect> queryCollectList(@Param("myPageHelper")MyPageHelper myPageHelper);

    List<Footprint> queryFootprintList(@Param("myPageHelper")MyPageHelper myPageHelper);

    List<History> querySearchHistoryList(@Param("myPageHelper")MyPageHelper myPageHelper);

    List<FeedBack> queryFeedbackList(@Param("myPageHelper")MyPageHelper myPageHelper);

    OrderUser queryUserById(@Param("id")int id);



    int queryCountSameUsername(@Param("username") String username);

    int insertUserForRegister(@Param("new") RegisterVo registerVo);

    UserInfo getUserInfoByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    String getPasswordByUsername(@Param("username") String principal);

}
