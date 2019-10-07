package com.j4h.mall.controller.wx.region;

import com.j4h.mall.service.wx.region.WxRegionService;
import com.j4h.mall.util.LoginOrNotUtils;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/region")
public class WxRegionController {

    @Autowired
    WxRegionService wxRegionService;

    @GetMapping("/list")
    public BaseRespVo queryRegionListForWx(int pid) {
        if (!LoginOrNotUtils.isLogin()) {
            return BaseRespVo.fail(501,"请登陆后再访问");
        }
        return BaseRespVo.ok(wxRegionService.queryRegionListByPid(pid));
    }
}
