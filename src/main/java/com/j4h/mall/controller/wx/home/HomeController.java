package com.j4h.mall.controller.wx.home;

import com.j4h.mall.service.wx.home.HomeService;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.wx.home.BeanForData.HomeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/home")
public class HomeController {

    @Autowired
    HomeService homeService;

    @RequestMapping("/index")
    public BaseRespVo homeIndex() {
        HomeData homeData = homeService.queryHomeData();
        return BaseRespVo.ok(homeData);
    }

}
