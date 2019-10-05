package com.j4h.mall.controller.wx.address;

import com.j4h.mall.service.wx.address.WxAddressService;
import com.j4h.mall.util.LoginOrNotUtils;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/address")
public class WxAddressController {

    @Autowired
    WxAddressService wxAddressService;

    @GetMapping("/list")
    public BaseRespVo getAddressList() {
        Integer userId = LoginOrNotUtils.getUserId();
        if (userId == null) {
            return BaseRespVo.fail(501, "请登录后再访问！");
        }
        return BaseRespVo.ok(wxAddressService.getAddressListByUserId(userId));
    }
}
