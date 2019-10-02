package com.j4h.mall.controller.mall;

import com.j4h.mall.model.mall.issue.Issue;
import com.j4h.mall.service.mall.IssueService;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.mall.issue.CreateIssueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/issue")
public class IssueController {
    @Autowired
    IssueService issueService;

    @GetMapping("/list")
    public BaseRespVo queryIssueList(int page,int limit,String sort,String order,String question) {
        return BaseRespVo.ok(issueService.queryIssueList(page, limit, sort, order,question));
    }

    @PostMapping("/create")
    public BaseRespVo createIssue(@RequestBody CreateIssueVo createIssueVo) {
        return BaseRespVo.ok(issueService.createIssue(createIssueVo));
    }

    @PostMapping("/update")
    public BaseRespVo updateIssue(@RequestBody Issue issue) {
        return BaseRespVo.ok(issueService.updateIssue(issue));
    }

    @PostMapping("/delete")
    public BaseRespVo deleteIssue(@RequestBody Issue issue) {
        int result = issueService.deleteIssue(issue);
        if (result == 1) {
            return BaseRespVo.ok(null);
        } else {
            BaseRespVo baseRespVo = new BaseRespVo();
            baseRespVo.setErrmsg("删除失败");
            baseRespVo.setErrno(402);
            return baseRespVo;
        }
    }
}
