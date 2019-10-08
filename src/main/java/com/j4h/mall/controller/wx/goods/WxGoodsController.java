package com.j4h.mall.controller.wx.goods;

import com.j4h.mall.model.goods.Goods;
import com.j4h.mall.model.goods.GoodsList;
import com.j4h.mall.model.wx.goods.CategoryDate;
import com.j4h.mall.model.wx.goods.GoodsDetail;
import com.j4h.mall.model.wx.goods.GoodsListData;
import com.j4h.mall.service.wx.goods.WxGoodsService;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.goods.BeanForGoodsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.j4h.mall.util.LoginOrNotUtils.*;

import java.util.List;

@RestController
@RequestMapping("/wx/goods")
public class WxGoodsController {
    @Autowired
    WxGoodsService wxGoodsService;

    @GetMapping("/count")
    public BaseRespVo queryGoodsCount() {
        return BaseRespVo.ok(wxGoodsService.queryGoodsCountForWx());
    }
    @GetMapping("/list")
    public BaseRespVo queryGoodsList(BeanForGoodsPage beanForGoodsPage) {
        GoodsListData goodsListData= wxGoodsService.queryGoodsList(beanForGoodsPage);
        return BaseRespVo.ok(goodsListData);
    }
    @GetMapping("/category")
    public BaseRespVo queryCategories(int id) {
        CategoryDate categoryDate = wxGoodsService.queryCategory(id);
        return BaseRespVo.ok(categoryDate);
    }
    @GetMapping("/detail")
    public BaseRespVo queryGoodsDetail(int id) {
        Integer userId = getUserId();
        GoodsDetail goodsDetail = wxGoodsService.queryGoodsDetail(userId, id);
        return BaseRespVo.ok(goodsDetail);
    }
    @GetMapping("/related")
    public BaseRespVo queryRelatedGoods(int id) {
        GoodsList goodsList = wxGoodsService.queryRelatedGoods(id);
        return BaseRespVo.ok(goodsList);
    }
}
