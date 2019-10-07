package com.j4h.mall.controller.wx.search;

import com.j4h.mall.model.wx.search.SearchResponseVo;
import com.j4h.mall.model.wx.topic.WxTopicVo;
import com.j4h.mall.service.wx.search.WxSearchService;
import com.j4h.mall.util.LoginOrNotUtils;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*SearchIndex: WxApiRoot + 'search/index', //搜索关键字√
  SearchResult: WxApiRoot + 'search/result', //搜索结果 没找到
  SearchHelper: WxApiRoot + 'search/helper', //搜索帮助√
  SearchClearHistory: WxApiRoot + 'search/clearhistory', //搜索历史清除
*/
@RestController
@CrossOrigin
@RequestMapping("/wx/search")
public class WxSearchController {
    @Autowired
    WxSearchService wxSearchService;

    @GetMapping("/index")
    public BaseRespVo showSearchIndex(){
        SearchResponseVo searchList = wxSearchService.getSearchList();
        return BaseRespVo.ok(searchList);
    }

    @GetMapping("/helper")
    public BaseRespVo showSearchHelper(String keyword){
        String[] strings = wxSearchService.showSearchHelper(keyword);
        return BaseRespVo.ok(strings);
    }

    @PostMapping("/clearhistory")
    public BaseRespVo clearHistory(){
        Integer userId = LoginOrNotUtils.getUserId();
        if (userId == null){
            userId = -1;
        }
        int i = wxSearchService.deleteSearchHistory(userId);
        return BaseRespVo.ok(null);
    }
}
