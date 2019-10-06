package com.j4h.mall.model.wx.search;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/6 20:50
 */
public class SearchResponseVo {
    KeywordOfSearch defaultKeyword;
    String[] historyKeywordList;
    List<KeywordOfSearch> hotKeywordList;

    public KeywordOfSearch getDefaultKeyword() {
        return defaultKeyword;
    }

    public void setDefaultKeyword(KeywordOfSearch defaultKeyword) {
        this.defaultKeyword = defaultKeyword;
    }

    public String[] getHistoryKeywordList() {
        return historyKeywordList;
    }

    public void setHistoryKeywordList(String[] historyKeywordList) {
        this.historyKeywordList = historyKeywordList;
    }

    public List<KeywordOfSearch> getHotKeywordList() {
        return hotKeywordList;
    }

    public void setHotKeywordList(List<KeywordOfSearch> hotKeywordList) {
        this.hotKeywordList = hotKeywordList;
    }
}
