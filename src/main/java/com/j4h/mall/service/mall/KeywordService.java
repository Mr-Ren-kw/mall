package com.j4h.mall.service.mall;

import com.j4h.mall.model.PageBean;
import com.j4h.mall.model.mall.keyword.Keyword;
import com.j4h.mall.vo.mall.keyword.CreateKeywordVo;

public interface KeywordService {
    PageBean<Keyword> queryKeywordList(int page, int limit, String sort, String order,String keyword,String url);

    Keyword createKeyword(CreateKeywordVo createKeywordVo);

    Keyword updateKeyword(Keyword keyword);

    int deleteKeywordById(int id);
}
