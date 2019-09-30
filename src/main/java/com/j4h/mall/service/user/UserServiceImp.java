package com.j4h.mall.service.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j4h.mall.mapper.user.UserMapper;
import com.j4h.mall.model.PageBean;
import com.j4h.mall.model.user.Address;
import com.j4h.mall.model.user.User;
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
        if (myPageHelper.getUsername()!=null){
            myPageHelper.setUsername("%"+myPageHelper.getUsername()+"%");
        }
        if (myPageHelper.getMobile()!=null){
            myPageHelper.setMobile("%"+myPageHelper.getMobile()+"%");
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
        for (Address address : addresses) {
          int areaId=  address.getAreaId();
          String area=userMapper.queryRegionNameById(areaId);
          address.setArea(area);

          int provinceId=  address.getProvinceId();
        String province=  userMapper.queryRegionNameById(provinceId);
        address.setProvice(province);

           int cityId= address.getCityId();
          String city=  userMapper.queryRegionNameById(cityId);
          address.setCity(city);
        }
        PageBean pagebean = getPagebean(addresses);
        return pagebean;
    }
}
