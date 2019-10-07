package com.j4h.mall.service.wx.auth;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.j4h.mall.config.aliyun.AliyunConfig;
import com.j4h.mall.mapper.user.UserMapper;
import com.j4h.mall.vo.wx.RegisterVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class WxAuthServiceImpl implements WxAuthService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    AliyunConfig aliyunConfig;

    @Override
    public Serializable getRegCaptcha(String mobile) {

        String code = (int) ((Math.random() * 9 + 1) * 100000) + "";
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("code",code);
        String accessKeyId = aliyunConfig.getAccessKeyId();
        String accessSecret = aliyunConfig.getAccessSecret();
        String regionId = aliyunConfig.getSmsConfig().getRegionId();
        String templateCode = aliyunConfig.getSmsConfig().getTemplateCode();
        String signName = aliyunConfig.getSmsConfig().getSignName();

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", regionId);
        request.putQueryParameter("PhoneNumbers", mobile);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        try{
            client.getCommonResponse(request);
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return session.getId();
    }

    @Override
    public int registerUser(RegisterVo registerVo) {
        // 查询是否有重复的用户名
        int count = userMapper.queryCountSameUsername(registerVo.getUsername());
        if (count != 0) {
            return 0;
        }
        count = userMapper.insertUserForRegister(registerVo);
        return count;
    }
}
