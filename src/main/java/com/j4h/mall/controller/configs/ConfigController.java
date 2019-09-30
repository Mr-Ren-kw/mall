package com.j4h.mall.controller.configs;

import com.j4h.mall.model.configs.MallSystemMsg;
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
        MallSystemMsg mallSystemMsg = configService.getMallSystemExpressMsg();
        return BaseRespVo.ok(mallSystemMsg);
    }

    @RequestMapping(value = "/express",method = RequestMethod.POST)
    public BaseRespVo postMethodExpress(@RequestBody MallSystemMsg mallSystemMsg){
        boolean flag = configService.updateMallSystemExpressMsg(mallSystemMsg);

        return BaseRespVo.ok(null);
    }

    @RequestMapping(value = "/order",method = RequestMethod.GET)
    public BaseRespVo getMethodOrder(){
        MallSystemMsg mallSystemMsg = configService.getMallSystemOrderMsg();
        return BaseRespVo.ok(mallSystemMsg);
    }

    @RequestMapping(value = "/order",method = RequestMethod.POST)
    public BaseRespVo postMethodOrder(@RequestBody MallSystemMsg mallSystemMsg){
        boolean flag = configService.updateMallSystemOrderMsg(mallSystemMsg);

        return BaseRespVo.ok(null);
    }

    @RequestMapping(value = "/wx",method = RequestMethod.GET)
    public BaseRespVo getMethodWx(){
        MallSystemMsg mallSystemMsg = configService.getMallSystemWxMsg();
        return BaseRespVo.ok(mallSystemMsg);
    }

    @RequestMapping(value = "/wx",method = RequestMethod.POST)
    public BaseRespVo postMethodWx(@RequestBody MallSystemMsg mallSystemMsg){
        boolean flag = configService.updateMallSystemWxMsg(mallSystemMsg);

        return BaseRespVo.ok(null);
    }
}
