package com.j4h.mall.service.mall;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.mall.IssueMapper;
import com.j4h.mall.model.PageBean;
import com.j4h.mall.model.mall.issue.Issue;
import com.j4h.mall.vo.mall.issue.CreateIssueVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    IssueMapper issueMapper;

    @Override
    public PageBean<Issue> queryIssueList(int page, int limit, String sort, String order, String question) {
        PageHelper.startPage(page, limit, sort + " " + order);
        if (question != null && !"".equals(question)) {
            question = "%" + question + "%";
        }
        List<Issue> issueList = issueMapper.queryIssueList(question);
        PageInfo<Issue> issuePageInfo = new PageInfo<>(issueList);
        PageBean<Issue> issuePageBean = new PageBean<>();
        issuePageBean.setTotal(issuePageInfo.getTotal());
        issuePageBean.setItems(issueList);
        return issuePageBean;
    }

    @Override
    public Issue createIssue(CreateIssueVo createIssueVo) {
        // 插入问题并返回id
        Issue issue = new Issue();
        issueMapper.createIssue(createIssueVo, issue);
        // 通过id查询
        return issueMapper.queryIssueById(issue.getId());
    }

    @Override
    public Issue updateIssue(Issue issue) {
        // 更新
        issueMapper.updateIssue(issue);
        // 查询
        return issueMapper.queryIssueById(issue.getId());
    }

    @Override
    public int deleteIssue(Issue issue) {
        return issueMapper.deleteIssueById(issue.getId());
    }
}
