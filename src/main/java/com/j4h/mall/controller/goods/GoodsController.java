package com.j4h.mall.controller.goods;

import com.j4h.mall.model.PageBean;
import com.j4h.mall.model.goods.Goods;
import com.j4h.mall.service.goods.GoodsService;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.goods.CatAndBrandVo;
import com.j4h.mall.vo.goods.GoodsItemVo;
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

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public BaseRespVo<GoodsItemVo> getGoodsDetail(int id) {
        GoodsItemVo goodsItemVo = goodsService.getGoodsDetail(id);
        return ok(goodsItemVo);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public BaseRespVo updateGoods(@RequestBody GoodsItemVo goodsItemVo) {
        goodsService.updateGoods(goodsItemVo);
        return ok(null);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseRespVo deleteGoods(@RequestBody Goods goods) {
        goodsService.deleteGoods(goods.getId());
        return ok(null);
    }
}
