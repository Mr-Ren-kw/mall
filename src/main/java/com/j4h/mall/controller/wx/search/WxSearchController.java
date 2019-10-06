package com.j4h.mall.controller.wx.search;

import com.j4h.mall.model.wx.search.SearchResponseVo;
import com.j4h.mall.model.wx.topic.WxTopicVo;
import com.j4h.mall.service.wx.search.WxSearchService;
import com.j4h.mall.vo.BaseRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*SearchIndex: WxApiRoot + 'search/index', //搜索关键字√
  SearchResult: WxApiRoot + 'search/result', //搜索结果
  SearchHelper: WxApiRoot + 'search/helper', //搜索帮助
  SearchClearHistory: WxApiRoot + 'search/clearhistory', //搜索历史清楚
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


}
