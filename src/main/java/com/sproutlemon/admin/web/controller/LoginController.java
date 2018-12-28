package com.sproutlemon.admin.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sproutlemon.admin.entity.log.LogLogin;
import com.sproutlemon.admin.entity.sys.SysAccount;
import com.sproutlemon.admin.enums.LoginFailureType;
import com.sproutlemon.admin.service.log.LogLoginService;
import com.sproutlemon.admin.service.sys.SysAccountService;
import com.sproutlemon.admin.web.WebConstants;

@Controller
public class LoginController extends AdminController {

	@Autowired
	SysAccountService accountService;

	@Autowired
	LogLoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, ModelMap model, String requestUrl) {

		Object sysAccount = request.getSession().getAttribute(WebConstants.SYS_ACCOUNT_SESSION_KEY);// 获得session中的用户
		if (sysAccount != null) {
			return "redirect:" + WebConstants.INDEX_PATH;
		}

		logger.info("登录后跳转的地址:::" + requestUrl);
		model.addAttribute("loginedUrl", requestUrl);
		return "login";// 跳转到登录页面
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:" + WebConstants.LOGIN_PATH;
	}

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, String account, String password) {
		Date now = new Date();
		String ipAddr = request.getRemoteAddr();
		logger.info("收到来自" + ipAddr + "的登录请求，account:::" + account + ", password:::" + password);

		LogLogin logLogin = new LogLogin(account, now, ipAddr, 0, 1, LoginFailureType.NONE);// 初始化日志记录

		SysAccount sysAccount = accountService.findByAccount(account);
		if (sysAccount == null) { // 账号不存在
			logLogin.setFailureType(LoginFailureType.ACCOUNT_DOES_NOT_EXIST);
			logLogin.setIsSuccess(0);
			loginService.save(logLogin);// 写登录日志
			return LoginFailureType.ACCOUNT_DOES_NOT_EXIST.toString(); // 返回登录标识

		}

		if (!sysAccount.getPassword().equalsIgnoreCase(DigestUtils.md5DigestAsHex(password.getBytes()))) { // 密码错误
			logLogin.setFailureType(LoginFailureType.WRONG_PASSWORD);
			logLogin.setIsSuccess(0);
			loginService.save(logLogin);// 写登录日志
			return LoginFailureType.WRONG_PASSWORD.toString(); // 返回登录标识
		}

		sysAccount.setLastLoginTime(now);
		request.getSession().setAttribute(WebConstants.SYS_ACCOUNT_SESSION_KEY, sysAccount); // 登录成功，写入session
		loginService.save(logLogin);// 写登录日志

		return logLogin.getFailureType().toString();// 返回登录标识

	}

}
