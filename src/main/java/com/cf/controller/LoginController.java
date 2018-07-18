package com.cf.controller;

//***************登录模块需要的控制器***************//
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cf.result.Result;
import com.cf.service.RegisterService;
import com.cf.service.UserService;
import com.cf.vo.LoginVo;
import com.cf.vo.RegisterVo;
import com.cf.vo.changePWDVO;

@Controller
@RequestMapping("/login")
public class LoginController {

	private static Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	// 映射到登录界面
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}

	// 登录功能的具体实现
	@RequestMapping("/login")
	@ResponseBody
	public Result<String> login(HttpSession session, HttpServletResponse response, LoginVo loginVo) {
		log.info(loginVo.toString());
		Integer id = userService.login(response, loginVo);
		session.setMaxInactiveInterval(60 * 15); // 设置session失效时常为15min
		session.setAttribute("loginVo", loginVo); // 将登录的账号密码、id号写入到session中去。
		session.setAttribute("myId", id); // 以便于在其他页面做账户的验证

		// new 2018 7 11
		// 实现了当在某个页面点击登录按钮，登录完成之后跳转回原来的页面//
		if (session.getAttribute("preProject") != null) {
			int projID = (Integer) session.getAttribute("preProject");
			return Result.success(String.valueOf(projID));
		}

		// 返回success表示 之前无浏览项目
		return Result.success("success");
	}

	// 退出登录
	@RequestMapping("/loginOut")
	@ResponseBody
	public Result<String> loginOut(HttpSession session, HttpServletResponse response) {
		session.invalidate(); // 使session无效即可
		return Result.success("success");
	}

	// 页面的映射
	@RequestMapping("/toChangePWD")
	public String toChangePWD() {
		log.info("changePWD/tochangePWD");
		return "changePWD";
	}

	// 修改密码的实现
	@RequestMapping("/changePWD")
	@ResponseBody
	public Result<String> changePWD(HttpServletResponse response, changePWDVO changePWDVo) {
		log.info(changePWDVo.toString());
		log.info("changePWD/changePWD");
		String result = userService.changePWD(response, changePWDVo); // 直接调用服务层的修改密码方法
		return Result.success(result);
	}

	// 映射到登录页面
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "login";
	}

	// 注册的映射方法。最后会返回注册的结果
	@RequestMapping("/register")
	@ResponseBody
	public Result<String> register(HttpServletResponse response, RegisterVo registerVo) {
		log.info(registerVo.toString());
		String result = userService.register(response, registerVo);
		Result<String> rst = Result.success(result);
		log.info(String.valueOf(rst.getCode()));
		return rst;
	}

	// 用于发送手机验证码
	@RequestMapping("/sendSMS")
	@ResponseBody
	public Result<String> sendSMS(HttpServletResponse response, String phone) throws JSONException {
		String code = RegisterService.getCode(phone);
		// 发送验证码
		log.info(phone);
		return Result.success(code);
	}

}
