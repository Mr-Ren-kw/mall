package com.j4h.mall.controller.extension;

import com.j4h.mall.model.extension.ad.BeanForDatabase.Advertise;
import com.j4h.mall.service.extension.ad.AdService;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.extension.BeanForData.PageData;
import com.j4h.mall.vo.extension.BeanForRequest.AdPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/ad")
public class AdController {

    @Autowired
    AdService adService;

    @GetMapping("/list")
    public BaseRespVo adPage(AdPageRequest adPageRequest) {
        PageData adPageData = adService.queryAdByPage(adPageRequest);
        return BaseRespVo.ok(adPageData);
    }
    @RequestMapping("/update")
    public BaseRespVo updateAd(@RequestBody Advertise advertise) {
        advertise = adService.updateAd(advertise);
        return BaseRespVo.ok(advertise);
    }
    @RequestMapping("/delete")
    public BaseRespVo deleteAd(@RequestBody Advertise advertise) {
        adService.deleteAdById(advertise.getId());
        return BaseRespVo.ok(null);
    }
    @RequestMapping("/create")
    public BaseRespVo createAd(@RequestBody Advertise advertise) {
        Advertise advertise1 = adService.addAd(advertise);
        return BaseRespVo.ok(advertise1);
    }
}
