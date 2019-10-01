package com.j4h.mall.service.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.user.UserMapper;
import com.j4h.mall.model.PageBean;
import com.j4h.mall.model.user.*;
import com.j4h.mall.vo.user.MyPageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper userMapper;


    public static PageBean getPagebean(List object){
        PageInfo PageInfo = new PageInfo(object);
        long total = PageInfo.getTotal();
        PageBean pageBean = new PageBean();
        pageBean.setTotal((int)total);
        pageBean.setItems(object);
        return pageBean;
    }
    @Override
    public PageBean queryUserList(MyPageHelper myPageHelper) {
        PageHelper.startPage(myPageHelper.getPage(),myPageHelper.getLimit(),myPageHelper.getSort()+" "+myPageHelper.getOrder());

        if (myPageHelper.getMobile()!=null){
            myPageHelper.setMobile("%"+myPageHelper.getMobile()+"%");
        }
        if (myPageHelper.getUsername()!=null){
            myPageHelper.setUsername("%"+myPageHelper.getUsername()+"%");
        }
       List<User> users=userMapper.queryUsers(myPageHelper);
        PageBean pagebean = getPagebean(users);
        return pagebean;
    }

    @Override
    public PageBean queryAddressList(MyPageHelper myPageHelper) {

        PageHelper.startPage(myPageHelper.getPage(),myPageHelper.getLimit(),myPageHelper.getSort()+" "+myPageHelper.getOrder());
        if (myPageHelper.getName()!=null){
            myPageHelper.setName("%"+myPageHelper.getName()+"%");
        }
       List<Address> addresses=userMapper.queryAddressList(myPageHelper);
        PageBean pagebean = getPagebean(addresses);
        return pagebean;
    }

    @Override
    public PageBean queryCollectList(MyPageHelper myPageHelper) {
        PageHelper.startPage(myPageHelper.getPage(),myPageHelper.getLimit(),myPageHelper.getSort()+" "+myPageHelper.getOrder());
      List<Collect> collectList=  userMapper.queryCollectList(myPageHelper);
        PageBean pagebean = getPagebean(collectList);
        return pagebean;

    }

    @Override
    public PageBean queryFootprintList(MyPageHelper myPageHelper) {
        PageHelper.startPage(myPageHelper.getPage(),myPageHelper.getLimit(),myPageHelper.getSort()+" "+myPageHelper.getOrder());
       List<Footprint> footprintList= userMapper.queryFootprintList(myPageHelper);
        PageBean pagebean = getPagebean(footprintList);
        return pagebean;
    }

    @Override
    public PageBean querySearchHistoryList(MyPageHelper myPageHelper) {
        PageHelper.startPage(myPageHelper.getPage(),myPageHelper.getLimit(),myPageHelper.getSort()+" "+myPageHelper.getOrder());
      if (myPageHelper.getKeyword()!=null){
          myPageHelper.setKeyword("%"+myPageHelper.getKeyword()+"%");
      }
       List<History> historyList= userMapper.querySearchHistoryList(myPageHelper);
        PageBean pagebean = getPagebean(historyList);
        return pagebean;
    }

    @Override
    public PageBean queryFeedbackList(MyPageHelper myPageHelper) {
        PageHelper.startPage(myPageHelper.getPage(),myPageHelper.getLimit(),myPageHelper.getSort()+" "+myPageHelper.getOrder());

        if (myPageHelper.getUsername()!=null){
           myPageHelper.setUsername("%"+myPageHelper.getUsername()+"%");
       }
        List<FeedBack> feedBackList = userMapper.queryFeedbackList(myPageHelper);
        for (FeedBack feedBack : feedBackList) {
            String pic = feedBack.getPic();
            String[] split = pic.split(",");
            feedBack.setPicUrls(split);
        }
        PageBean pagebean = getPagebean(feedBackList);
        return pagebean;
    }
}
