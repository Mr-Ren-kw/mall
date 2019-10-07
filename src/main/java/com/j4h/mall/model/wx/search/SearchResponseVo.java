package com.j4h.mall.model.wx.search;

import java.util.List;

/**
 * @author sld
 * @version 1.0
 * @date 2019/10/6 20:50
 */
public class SearchResponseVo {
    private KeywordOfSearch defaultKeyword;
    private List<HistoryKeyword> historyKeywordList;
    private List<KeywordOfSearch> hotKeywordList;

    public KeywordOfSearch getDefaultKeyword() {
        return defaultKeyword;
    }

    public void setDefaultKeyword(KeywordOfSearch defaultKeyword) {
        this.defaultKeyword = defaultKeyword;
    }

    public List<HistoryKeyword> getHistoryKeywordList() {
        return historyKeywordList;
    }

    public void setHistoryKeywordList(List<HistoryKeyword> historyKeywordList) {
        this.historyKeywordList = historyKeywordList;
    }

    public List<KeywordOfSearch> getHotKeywordList() {
        return hotKeywordList;
    }

    public void setHotKeywordList(List<KeywordOfSearch> hotKeywordList) {
        this.hotKeywordList = hotKeywordList;
    }
}
