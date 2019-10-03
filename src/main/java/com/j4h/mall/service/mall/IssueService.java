package com.j4h.mall.service.mall;

import com.j4h.mall.model.PageBean;
import com.j4h.mall.model.mall.issue.Issue;
import com.j4h.mall.vo.mall.issue.CreateIssueVo;

public interface IssueService {
    PageBean<Issue> queryIssueList(int page, int limit, String sort, String order, String question);

    Issue createIssue(CreateIssueVo createIssueVo);

    Issue updateIssue(Issue issue);

    int deleteIssue(Issue issue);
}
