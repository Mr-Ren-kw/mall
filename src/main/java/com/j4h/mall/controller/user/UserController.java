package com.j4h.mall.controller.user;


import com.j4h.mall.model.PageBean;
import com.j4h.mall.service.user.UserService;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.user.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
   @RequestMapping("admin/user/list")
    public BaseRespVo queryUserList(MyPageHelper myPageHelper){
      PageBean pageBean= userService.queryUserList(myPageHelper);
       BaseRespVo<PageBean> ok = BaseRespVo.ok(pageBean);
       return ok;
   }

   @RequestMapping("admin/address/list")
    public BaseRespVo queryAddressList(MyPageHelper myPageHelper){
      PageBean pageBean= userService.queryAddressList(myPageHelper);
       BaseRespVo<PageBean> ok = BaseRespVo.ok(pageBean);
       return ok;
   }
}
