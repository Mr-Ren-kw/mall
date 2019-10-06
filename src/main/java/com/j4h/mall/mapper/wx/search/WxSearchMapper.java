package com.j4h.mall.mapper.wx.search;

import com.j4h.mall.model.wx.search.KeywordOfSearch;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/6 21:10
 */
public interface WxSearchMapper {
    KeywordOfSearch queryDefaultKeyword();
    String[] queryHistoryKeywordList(int UserId);
    List<KeywordOfSearch> hotKeywordList();
    String[] showSearchHelper(String keyword);
}
