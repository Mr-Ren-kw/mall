package com.j4h.mall.controller.wx.catalog;

import com.j4h.mall.service.wx.catalog.WxCatalogService;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/catalog")
public class WxCatalogController {

    @Autowired
    WxCatalogService catalogService;

    @GetMapping("/index")
    public BaseRespVo getCatalogIndex() {
        return BaseRespVo.ok(catalogService.getCatalogIndex());
    }

    @GetMapping("/current")
    public BaseRespVo getCurrentCategory(int id) {
        return BaseRespVo.ok(catalogService.getCurrentCategory(id));
    }
}
