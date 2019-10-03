package com.j4h.mall.controller.mall;

import com.j4h.mall.service.mall.OrderService;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("list")
    public BaseRespVo queryOrderList(int page,int limit,String sort,String order,Integer[] orderStatusArray,String userId,String orderSn) {
        BaseRespVo baseRespVo = new BaseRespVo();
        Integer userIdInteger = null;
        Integer orderSnInteger = null;
        if (userId != null && !"".equals(userId)) {
            try {
                userIdInteger = Integer.parseInt(userId);
            } catch (Exception e) {
                baseRespVo.setErrno(402);
                baseRespVo.setErrmsg("参数值不对");
                return baseRespVo;
            }
        }
        if (orderSn != null && !"".equals(orderSn)) {
            try {
                orderSnInteger = Integer.parseInt(orderSn);
            } catch (Exception e) {
                baseRespVo.setErrmsg("参数值不对");
                baseRespVo.setErrno(402);
                return baseRespVo;
            }
        }

        return BaseRespVo.ok(orderService.queryOrderList(page, limit, sort, order,userIdInteger,orderSnInteger,orderStatusArray));
    }

    @GetMapping("/detail")
    public BaseRespVo queryOrderDetail(int id) {
        return BaseRespVo.ok(orderService.queryOrderDetail(id));
    }
}
