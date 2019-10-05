package com.j4h.mall.controller.wx.cart;

import com.j4h.mall.model.wx.cart.AddCart;
import com.j4h.mall.model.wx.cart.CheckedCart;
import com.j4h.mall.model.wx.cart.IndexCart;
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
    WxCartService wxCartService;


    @RequestMapping("add")
    public BaseRespVo<Integer> addToCart(@RequestBody AddCart addCart) {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
//        String username = (String) session.getAttribute("username");
        Integer userId = (Integer) session.getAttribute("userId");
        if(userId == null) {
            // userId等于null说明没有登录
            return BaseRespVo.fail(501, "请登录");
        }
        int total = wxCartService.addCart(userId, addCart);
        if (total != -1) {
            return BaseRespVo.ok(total);
        }
        return BaseRespVo.badArgument402();
    }

    @RequestMapping("index")
    public BaseRespVo<IndexCart> cartIndex() {
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        if(userId == null) {
            return BaseRespVo.fail(501, "请登录");
        }
        IndexCart indexCart = wxCartService.getCartInfo(userId);
        return BaseRespVo.ok(indexCart);
    }

    @RequestMapping("checked")
    public BaseRespVo<IndexCart> checkedCart(@RequestBody CheckedCart checkedCart) {
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        if(userId == null) {
            return BaseRespVo.fail(501, "请登录");
        }
        wxCartService.checkedProducts(userId, checkedCart);
        IndexCart indexCart = wxCartService.getCartInfo(userId);
        return BaseRespVo.ok(indexCart);
    }

    @RequestMapping("goodscount")
    public BaseRespVo<Integer> countCartGoods() {
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        if(userId == null) {
            return BaseRespVo.fail(501, "请登录");
        }
        Integer cnt = wxCartService.getAllCartGoodsCount(userId);
        return BaseRespVo.ok(cnt);
    }
}
