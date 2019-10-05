package com.j4h.mall.controller.wx.user;
import com.j4h.mall.model.wx.user.AllGoodsList;
import com.j4h.mall.service.wx.user.WxUserOrderService;
import com.j4h.mall.util.LoginOrNotUtils;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.wx.user.UserOrderPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class WxUserOrderController {
    @Autowired
    WxUserOrderService wxUserOrderService;

    @RequestMapping("wx/order/list")
    public BaseRespVo orderList(UserOrderPage userOrderPage){
        boolean login = LoginOrNotUtils.isLogin();
        if (!login){
            return null;
        }
       AllGoodsList allGoodsList = wxUserOrderService.queryAllOrderList(userOrderPage);
        BaseRespVo<AllGoodsList> ok = BaseRespVo.ok(allGoodsList);
        return ok;
    }
}
