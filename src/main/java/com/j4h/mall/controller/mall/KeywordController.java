package com.j4h.mall.controller.mall;

import com.j4h.mall.model.mall.keyword.Keyword;
import com.j4h.mall.service.mall.KeywordService;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.mall.keyword.CreateKeywordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/keyword")
public class KeywordController {
    @Autowired
    KeywordService keywordService;

    @GetMapping("/list")
    public BaseRespVo queryKeywordList(int page, int limit, String sort, String order,String keyword,String url) {
        return BaseRespVo.ok(keywordService.queryKeywordList(page, limit, sort, order,keyword,url));
    }

    @PostMapping("/create")
    public BaseRespVo createKeyword(@RequestBody CreateKeywordVo createKeywordVo) {
        return BaseRespVo.ok(keywordService.createKeyword(createKeywordVo));
    }

    @PostMapping("/update")
    public BaseRespVo updateKeyword(@RequestBody Keyword keyword) {
        return BaseRespVo.ok(keywordService.updateKeyword(keyword));
    }

    @PostMapping("/delete")
    public BaseRespVo deleteKeyword(@RequestBody Keyword keyword) {
        int result = keywordService.deleteKeywordById(keyword.getId());
        if (result == 1) {
            return BaseRespVo.ok(null);
        } else {
            BaseRespVo<Object> baseRespVo = new BaseRespVo<>();
            baseRespVo.setErrno(402);
            baseRespVo.setErrmsg("删除失败！");
            return baseRespVo;
        }

    }
}
