package com.j4h.mall.service.user;

import com.j4h.mall.model.PageBean;
import com.j4h.mall.vo.user.MyPageHelper;

public interface UserService {
    PageBean queryUserList(MyPageHelper myPageHelper);

    PageBean queryAddressList(MyPageHelper myPageHelper);
}
