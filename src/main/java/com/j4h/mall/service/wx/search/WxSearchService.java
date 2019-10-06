package com.j4h.mall.service.wx.search;

import com.j4h.mall.model.wx.search.SearchResponseVo;

public interface WxSearchService {
    SearchResponseVo getSearchList();
    String[] showSearchHelper(String keyword);
}
