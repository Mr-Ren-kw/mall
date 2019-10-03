package com.j4h.mall.mapper.mall;

import com.j4h.mall.model.mall.issue.Issue;
import com.j4h.mall.vo.mall.issue.CreateIssueVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IssueMapper {

    List<Issue> queryIssueList(@Param("ques")String question);

    int createIssue(@Param("new") CreateIssueVo createIssueVo,@Param("result") Issue issue);

    Issue queryIssueById(@Param("id") int id);

    int updateIssue(@Param("new") Issue issue);

    int deleteIssueById(@Param("id") int id);
}
