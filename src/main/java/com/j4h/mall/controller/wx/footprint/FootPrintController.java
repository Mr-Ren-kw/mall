package com.j4h.mall.controller.wx.footprint;

import com.j4h.mall.model.wx.footprint.FootprintDataBean;
import com.j4h.mall.service.wx.footprint.WxFootprintService;
import com.j4h.mall.util.LoginOrNotUtils;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/footprint")
public class FootPrintController {

    @Autowired
    WxFootprintService wxFootprintService;

    @RequestMapping("list")
    public BaseRespVo getFootprintList(int page,int size){
        Integer userId = LoginOrNotUtils.getUserId();
        if (userId == null){
            return BaseRespVo.fail(501,"请登入后再访问");
        }
        FootprintDataBean data = wxFootprintService.getFootprintList(page,size,userId);
        return BaseRespVo.ok(data);
    }
}
