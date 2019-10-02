package com.j4h.mall.mapper.mall;

import com.j4h.mall.model.mall.keyword.Keyword;
import com.j4h.mall.vo.mall.keyword.CreateKeywordVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KeywordMapper {

    List<Keyword> queryKeywordList(@Param("keyword") String keyword,@Param("url") String url);

    int createKeyword(@Param("new") CreateKeywordVo createKeywordVo,@Param("result") Keyword keyword);

    Keyword queryKeywordById(@Param("id") int id);

    int updateKeyword(@Param("new") Keyword keyword);

    int deleteKeywordById(@Param("id") int id);
}
