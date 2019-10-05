package com.j4h.mall.controller.wx.auth;

import com.j4h.mall.model.wx.login.Login;
import com.j4h.mall.service.wx.user.WxUserSerivce;
import com.j4h.mall.shiro.CustomToken;
import com.j4h.mall.util.UserInfo;
import com.j4h.mall.util.UserToken;
import com.j4h.mall.util.UserTokenManager;
import com.j4h.mall.vo.BaseRespVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by little Stone
 * Date 2019/7/8 Time 20:55
 */
@RestController
@RequestMapping("/wx/auth")
public class WxAuthController {

	@Autowired
	WxUserSerivce wxUserSerivce;

	@RequestMapping("login")
	@ResponseBody
	public Object login(@RequestBody Login login, HttpServletRequest request) {
		if(login == null) {
			return BaseRespVo.badArgument402();
		}
		String username = login.getUsername();
		String password = login.getPassword();

		//*******************************
		//根据username和password查询user信息
		//*******************************
		// userInfo
//		UserInfo userInfo = new UserInfo();


		//********************************
		//根据获得userid
		//********************************
		// token
		CustomToken token = new CustomToken(username, password, "wx");
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			return new BaseRespVo(null, "用户帐号或密码不正确", 700);
		}
		Serializable id = subject.getSession().getId();
		UserInfo userInfo = wxUserSerivce.getUserInfoByUsernameAndPassword(username, password);
		if(userInfo == null) {
			return BaseRespVo.badArgument402();
		}
		Map<Object, Object> result = new HashMap<Object, Object>();
		subject.getSession().setAttribute("userId", userInfo.getId());
		result.put("token", id);
		// 设置token过期时间为登陆后的一天
		result.put("tokenExpire", LocalDateTime.now().plusDays(1));
		result.put("userInfo", userInfo);
		return BaseRespVo.ok(result);
	}
}
