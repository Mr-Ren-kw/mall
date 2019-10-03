package com.j4h.mall.controller.configs;

import com.j4h.mall.model.configs.MallSystemExpressMsg;
import com.j4h.mall.model.configs.MallSystemMsg;
import com.j4h.mall.model.configs.MallSystemOrderMsg;
import com.j4h.mall.model.configs.MallSystemWxMsg;
import com.j4h.mall.service.configs.ConfigService;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/config")
public class ConfigController {

    @Autowired
    ConfigService configService;

    @RequestMapping(value = "/mall",method = RequestMethod.GET)
    public BaseRespVo getMethodMall(){
        MallSystemMsg mallSystemMsg = configService.getMallSystemMsg();
        return BaseRespVo.ok(mallSystemMsg);
    }

    @RequestMapping(value = "/mall",method = RequestMethod.POST)
    public BaseRespVo postMethodMall(@RequestBody MallSystemMsg mallSystemMsg){
        boolean flag = configService.updateMallSystemMsg(mallSystemMsg);

        return BaseRespVo.ok(null);
    }

    @RequestMapping(value = "/express",method = RequestMethod.GET)
    public BaseRespVo getMethodExpress(){
        MallSystemExpressMsg mallSystemExpressMsg = configService.getMallSystemExpressMsg();
        return BaseRespVo.ok(mallSystemExpressMsg);
    }

    @RequestMapping(value = "/express",method = RequestMethod.POST)
    public BaseRespVo postMethodExpress(@RequestBody MallSystemExpressMsg mallSystemExpressMsg){
        boolean flag = configService.updateMallSystemExpressMsg(mallSystemExpressMsg);

        return BaseRespVo.ok(null);
    }

    @RequestMapping(value = "/order",method = RequestMethod.GET)
    public BaseRespVo getMethodOrder(){
        MallSystemOrderMsg mallSystemOrderMsg = configService.getMallSystemOrderMsg();
        return BaseRespVo.ok(mallSystemOrderMsg);
    }

    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public BaseRespVo postMethodOrder(@RequestBody MallSystemOrderMsg mallSystemOrderMsg){
        boolean flag = configService.updateMallSystemOrderMsg(mallSystemOrderMsg);

        return BaseRespVo.ok(null);
    }

    @RequestMapping(value = "/wx",method = RequestMethod.GET)
    public BaseRespVo getMethodWx(){
        MallSystemWxMsg mallSystemWxMsg = configService.getMallSystemWxMsg();
        return BaseRespVo.ok(mallSystemWxMsg);
    }

    @RequestMapping(value = "/wx",method = RequestMethod.POST)
    public BaseRespVo postMethodWx(@RequestBody MallSystemWxMsg mallSystemWxMsg){
        boolean flag = configService.updateMallSystemWxMsg(mallSystemWxMsg);

        return BaseRespVo.ok(null);
    }
}
