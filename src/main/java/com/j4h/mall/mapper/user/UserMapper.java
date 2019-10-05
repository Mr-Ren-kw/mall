package com.j4h.mall.mapper.user;

import com.j4h.mall.model.user.*;
import com.j4h.mall.vo.user.MyPageHelper;
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

    int queryUserIdByUsername(@Param("username") String principal);
}
