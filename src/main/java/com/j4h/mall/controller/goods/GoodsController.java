package com.j4h.mall.controller.goods;

import com.j4h.mall.model.PageBean;
import com.j4h.mall.service.goods.GoodsService;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.goods.CatAndBrandVo;
import com.j4h.mall.vo.goods.GoodsItemVo;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.j4h.mall.vo.BaseRespVo.ok;

@RestController
@RequestMapping("admin/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public BaseRespVo<PageBean> getGoodsInfo(int page, int limit, String sort, String order, Integer goodsSn, String name) {
        PageBean goodsInfo = goodsService.getGoodsInfo(page, limit, sort, order, goodsSn, name);
        BaseRespVo<PageBean> ok = ok(goodsInfo);
        return ok;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public BaseRespVo createGoods(@RequestBody GoodsItemVo goodsItemVo) {
        goodsService.createGoods(goodsItemVo);
        return ok(null);
    }

    @RequestMapping(value = "catAndBrand", method = RequestMethod.GET)
    public BaseRespVo<CatAndBrandVo> getCatAndBrand() {
        CatAndBrandVo catAndBrandVo = goodsService.getAllCatAndBrand();
        return ok(catAndBrandVo);

    }
}
