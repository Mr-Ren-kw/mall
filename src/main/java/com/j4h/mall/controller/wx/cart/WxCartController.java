package com.j4h.mall.controller.wx.cart;

import com.j4h.mall.model.wx.cart.*;
import com.j4h.mall.service.wx.cart.WxCartService;
import com.j4h.mall.vo.BaseRespVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;

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
            // 这里只需返回0即可，不然会强制跳转到登录界面
            return BaseRespVo.ok(0);
        }
        Integer cnt = wxCartService.getAllCartGoodsCount(userId);
        return BaseRespVo.ok(cnt);
    }

    @RequestMapping("update")
    public BaseRespVo updateCart(@RequestBody AddCart addCart) {
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        if(userId == null) {
            return BaseRespVo.fail(501, "请登录");
        }
        wxCartService.updateCartProduct(userId, addCart);
        return BaseRespVo.ok(null);
    }

    @RequestMapping("delete")
    public BaseRespVo<IndexCart> deleteCart(@RequestBody DeleteCart cart) {
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        if(userId == null) {
            return BaseRespVo.fail(501, "请登录");
        }
        wxCartService.deleteCart(userId, cart.getProductId());
        IndexCart indexCart = wxCartService.getCartInfo(userId);
        return BaseRespVo.ok(indexCart);
    }

    @RequestMapping("checkout")
    public BaseRespVo<CartCheckout> checkout(int cartId, int addressId, int couponId, int grouponRulesId) {
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        if(userId == null) {
            return BaseRespVo.fail(501, "请登录");
        }
        CartCheckout cartCheckout = wxCartService.checkout(userId, cartId, addressId, couponId, grouponRulesId);
        return BaseRespVo.ok(cartCheckout);
    }

    @RequestMapping("fastadd")
    public BaseRespVo<Integer> addfast(@RequestBody AddCart addCart) {
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        if(userId == null) {
            return BaseRespVo.fail(501, "请登录");
        }
        // 插入一条幽灵记录，他的delete=1,不会在购物车显示
        int res = wxCartService.addAnonCart(userId, addCart);
        if(res == -1) {
            return BaseRespVo.badArgument402();
        }
        return BaseRespVo.ok(res);
    }
}
