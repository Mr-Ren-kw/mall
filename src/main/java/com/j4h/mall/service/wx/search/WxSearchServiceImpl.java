package com.j4h.mall.service.wx.search;

import com.j4h.mall.mapper.wx.search.WxSearchMapper;
import com.j4h.mall.model.wx.search.KeywordOfSearch;
import com.j4h.mall.model.wx.search.SearchResponseVo;
import com.j4h.mall.util.LoginOrNotUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxSearchServiceImpl implements WxSearchService{
    @Autowired
    WxSearchMapper wxSearchMapper;

    @Override
    public SearchResponseVo getSearchList() {
        KeywordOfSearch keywordOfSearch = wxSearchMapper.queryDefaultKeyword();
        Integer userId = LoginOrNotUtils.getUserId();
        // 如果用户没登录，就不显示历史搜索历史（但不登录的话搜索历史放cookies里更好？）
        if (userId == null){
            userId = -1;
        }
        String[] strings = wxSearchMapper.queryHistoryKeywordList(userId);
        List<KeywordOfSearch> keywordOfSearches = wxSearchMapper.hotKeywordList();
        SearchResponseVo searchResponseVo = new SearchResponseVo();
        searchResponseVo.setDefaultKeyword(keywordOfSearch);
        searchResponseVo.setHistoryKeywordList(strings);
        searchResponseVo.setHotKeywordList(keywordOfSearches);
        return searchResponseVo;
    }
}
