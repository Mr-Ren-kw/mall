package com.j4h.mall.controller.wx.address;

import com.j4h.mall.model.wx.address.WxAddressDetail;
import com.j4h.mall.service.wx.address.WxAddressService;
import com.j4h.mall.util.LoginOrNotUtils;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.wx.address.DeleteAddressVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/detail")
    public BaseRespVo getAddressDetailById(int id) {
        if (!LoginOrNotUtils.isLogin()) {
            return BaseRespVo.fail(501, "请登录后再访问！");
        }
        return BaseRespVo.ok(wxAddressService.getAddressDetailById(id));
    }

    @PostMapping("/save")
    public BaseRespVo updateAddressById(@RequestBody WxAddressDetail wxAddressDetail) {
        Integer userId = LoginOrNotUtils.getUserId();
        if (userId == null) {
            return BaseRespVo.fail(501, "请登录后再访问！");
        }
        if (wxAddressDetail.getId() == 0) {
            // 新增收货地址
            return BaseRespVo.ok(wxAddressService.insertNewAddress(wxAddressDetail,userId));
        } else {
            // 修改收货地址
            return BaseRespVo.ok(wxAddressService.updateAddressById(wxAddressDetail));
        }
    }

    @PostMapping("/delete")
    public BaseRespVo deleteAddressById(@RequestBody DeleteAddressVo deleteAddressVo){
        if (!LoginOrNotUtils.isLogin()){
            return BaseRespVo.fail(501, "请登录后再访问！");
        }
        int result = wxAddressService.deleteAddressById(deleteAddressVo.getId());
        if (result == 1) {
            return BaseRespVo.ok(null);
        } else {
            return BaseRespVo.fail(402, "删除失败，请确认该地址是否存在！");
        }
    }
}
