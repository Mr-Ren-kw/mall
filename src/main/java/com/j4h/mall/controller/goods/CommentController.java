package com.j4h.mall.controller.goods;

import com.j4h.mall.model.PageBean;
import com.j4h.mall.model.goods.GoodsComment;
import com.j4h.mall.service.goods.GoodsService;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import static com.j4h.mall.vo.BaseRespVo.ok;

@RestController
@RequestMapping("admin/comment")
public class CommentController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public BaseRespVo<PageBean<GoodsComment>> getAllComments(int page, int limit, String sort, String order, Integer userId, Integer valueId) {
        PageBean<GoodsComment> pageBean = goodsService.getAllGoodsComment(page, limit, sort, order, userId, valueId);
        return ok(pageBean);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public BaseRespVo deleteComment(@RequestBody GoodsComment comment) {
        goodsService.deleteComment(comment.getId());
        return ok(null);
    }
}
