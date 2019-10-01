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

    @RequestMapping("admin/collect/list")
    public BaseRespVo queryCollectList(MyPageHelper myPageHelper){
      PageBean pageBean= userService.queryCollectList(myPageHelper);
       BaseRespVo<PageBean> ok = BaseRespVo.ok(pageBean);
       return ok;
   }

   @RequestMapping("admin/footprint/list")
    public BaseRespVo queryFootprintList(MyPageHelper myPageHelper){
      PageBean pageBean= userService.queryFootprintList(myPageHelper);
       BaseRespVo<PageBean> ok = BaseRespVo.ok(pageBean);
       return ok;
   }

   @RequestMapping("admin/history/list")
    public BaseRespVo querySearchHistoryList(MyPageHelper myPageHelper){
       PageBean pageBean=  userService.querySearchHistoryList(myPageHelper);
       BaseRespVo<PageBean> ok = BaseRespVo.ok(pageBean);
       return ok;
   }

   @RequestMapping("admin/feedback/list")
    public BaseRespVo queryFeedbackList(MyPageHelper myPageHelper){
       PageBean pageBean = userService.queryFeedbackList(myPageHelper);
       BaseRespVo<PageBean> ok = BaseRespVo.ok(pageBean);
       return ok;
   }
}
