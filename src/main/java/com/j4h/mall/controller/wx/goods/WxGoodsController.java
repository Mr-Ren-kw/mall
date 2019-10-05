package com.j4h.mall.controller.wx.goods;

import com.j4h.mall.service.wx.goods.WxGoodsService;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/goods")
public class WxGoodsController {
    @Autowired
    WxGoodsService wxGoodsService;

    @GetMapping("/count")
    public BaseRespVo queryGoodsCount() {
        return BaseRespVo.ok(wxGoodsService.queryGoodsCountForWx());
    }
}
