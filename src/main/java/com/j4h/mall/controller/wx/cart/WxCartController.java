package com.j4h.mall.controller.wx.cart;

import com.j4h.mall.model.wx.cart.AddCart;
import com.j4h.mall.service.wx.cart.WxCartService;
import com.j4h.mall.vo.BaseRespVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wx/cart")
public class WxCartController {

    @Autowired
    WxCartService cartService;


    @RequestMapping("add")
    public BaseRespVo<Integer> addToCart(@RequestBody AddCart addCart) {
        // 注意返回值是该用户购物车里所有商品数量
        // 暂时写死了，后面通过shrio得到
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
//        String username = (String) session.getAttribute("username");
        int userId = 1;
        int total = cartService.addCart(userId, addCart);
        if (total != -1) {
            return BaseRespVo.ok(total);
        }
        return BaseRespVo.badArgument402();
    }

}
