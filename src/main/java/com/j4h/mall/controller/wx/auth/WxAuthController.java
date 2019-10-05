package com.j4h.mall.controller.wx.auth;

import com.j4h.mall.model.wx.login.Login;
import com.j4h.mall.model.wx.login.RegisterResult;
import com.j4h.mall.service.wx.auth.WxAuthService;
import com.j4h.mall.util.UserInfo;
import com.j4h.mall.util.UserToken;
import com.j4h.mall.util.UserTokenManager;
import com.j4h.mall.vo.BaseRespVo;
import com.j4h.mall.vo.wx.RegCaptchaVo;
import com.j4h.mall.vo.wx.RegisterVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by little Stone
 * Date 2019/7/8 Time 20:55
 */
@RestController
@RequestMapping("/wx/auth")
public class WxAuthController {

	@Autowired
	WxAuthService wxAuthService;

	@RequestMapping("login")
	@ResponseBody
	public Object login(@RequestBody Login login, HttpServletRequest request) {
		String username = login.getUsername();
		String password = login.getPassword();

		//*******************************
		//根据username和password查询user信息
		//*******************************

		// userInfo
		UserInfo userInfo = new UserInfo();
		userInfo.setNickName(username);
		//userInfo.setAvatarUrl(user.getAvatar());


		//********************************
		//根据获得userid
		int userId = 1;
		//********************************
		// token
		UserToken userToken = UserTokenManager.generateToken(userId);

		Map<Object, Object> result = new HashMap<Object, Object>();
		result.put("token", userToken.getToken());
		result.put("tokenExpire", userToken.getExpireTime().toString());
		result.put("userInfo", userInfo);
		return BaseRespVo.ok(result);
	}

	@PostMapping("/regCaptcha")
	public BaseRespVo getRegCaptcha(@RequestBody RegCaptchaVo regCaptchaVo) {
		String mobile = regCaptchaVo.getMobile();
		return BaseRespVo.ok(wxAuthService.getRegCaptcha(mobile));
	}

	@PostMapping("/register")
	public BaseRespVo register(@RequestBody RegisterVo registerVo) {
		Session session = SecurityUtils.getSubject().getSession();
		String codeFromSession = (String) session.getAttribute("code");
		String code = registerVo.getCode();
		if (codeFromSession != null && codeFromSession.equals(code)) {
			// 注册逻辑，去数据库检查用户名和密码是否重复
			int result = wxAuthService.registerUser(registerVo);
			if (result == 0) {
				return BaseRespVo.fail(705,"该用户名已存在");
			}
			UserInfo userInfo = new UserInfo();
			userInfo.setNickName(registerVo.getUsername());
			userInfo.setAvatarUrl("");
			RegisterResult registerResult = new RegisterResult();
			registerResult.setToken(session.getId().toString());
			registerResult.setUserInfo(userInfo);
			session.setAttribute("userId",registerVo.getId());
			return BaseRespVo.ok(registerResult);
		} else {
			return BaseRespVo.fail(703, "验证码错误");
		}
	}
}
