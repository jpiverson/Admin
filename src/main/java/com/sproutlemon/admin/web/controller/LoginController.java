package com.sproutlemon.admin.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sproutlemon.admin.entity.log.LogLogin;
import com.sproutlemon.admin.entity.sys.SysAccount;
import com.sproutlemon.admin.enums.LoginFailureType;
import com.sproutlemon.admin.service.log.LogLoginService;
import com.sproutlemon.admin.service.sys.SysAccountService;

@Controller
public class LoginController extends AdminController {

	@Autowired
	SysAccountService accountService;

	@Autowired
	LogLoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() { //
		return "login";// 跳转到登录页面
	}

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, HttpServletRequest request, String account, String password) {
		String ipAddr = request.getRemoteAddr();
		logger.info("收到来自" + ipAddr + "的登录请求，account:::" + account + ", password:::" + password);

		LogLogin logLogin = new LogLogin(account, new Date(), ipAddr, 0, 1, LoginFailureType.NONE);// 初始化日志记录

		SysAccount userAccount = accountService.findByAccount(account);
		if (userAccount == null) { // 账号不存在
			logLogin.setFailureType(LoginFailureType.ACCOUNT_DOES_NOT_EXIST);
			logLogin.setIsSuccess(0);
			loginService.save(logLogin);// 写登录日志
			return LoginFailureType.ACCOUNT_DOES_NOT_EXIST.toString(); // 返回登录标识

		}

		if (!userAccount.getPassword().equalsIgnoreCase(DigestUtils.md5DigestAsHex(password.getBytes()))) { // 密码错误
			logLogin.setFailureType(LoginFailureType.WRONG_PASSWORD);
			logLogin.setIsSuccess(0);
			loginService.save(logLogin);// 写登录日志
			return LoginFailureType.WRONG_PASSWORD.toString(); // 返回登录标识
		}

		// 登录成功
		session.setAttribute("userAccount", userAccount); // 写入session
		loginService.save(logLogin);// 写登录日志

		return logLogin.getFailureType().toString();// 返回登录标识

	}

}
