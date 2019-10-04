package com.j4h.mall.service.mall;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.mall.KeywordMapper;
import com.j4h.mall.model.PageBean;
import com.j4h.mall.model.mall.keyword.Keyword;
import com.j4h.mall.util.MyStringUtils;
import com.j4h.mall.vo.mall.keyword.CreateKeywordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KeywordServiceImpl implements KeywordService {

    @Autowired
    KeywordMapper keywordMapper;

    @Override
    public PageBean<Keyword> queryKeywordList(int page, int limit, String sort, String order,String keyword,String url) {
        PageHelper.startPage(page, limit, sort + " " + order);
        keyword = MyStringUtils.searchKeyword(keyword);
        url = MyStringUtils.searchKeyword(url);
        List<Keyword> keywordList = keywordMapper.queryKeywordList(keyword,url);
        PageInfo<Keyword> keywordPageInfo = new PageInfo<>(keywordList);
        PageBean<Keyword> keywordPageBean = new PageBean<>();
        keywordPageBean.setItems(keywordList);
        keywordPageBean.setTotal(keywordPageInfo.getTotal());
        return keywordPageBean;
    }

    @Override
    public Keyword createKeyword(CreateKeywordVo createKeywordVo) {
        // 先新增
        Keyword keyword = new Keyword();
        keywordMapper.createKeyword(createKeywordVo, keyword);
        // 再查询
        return keywordMapper.queryKeywordById(keyword.getId());
    }

    @Override
    public Keyword updateKeyword(Keyword keyword) {
        keywordMapper.updateKeyword(keyword);
        return keywordMapper.queryKeywordById(keyword.getId());
    }

    @Override
    public int deleteKeywordById(int id) {
        return keywordMapper.deleteKeywordById(id);
    }
}
