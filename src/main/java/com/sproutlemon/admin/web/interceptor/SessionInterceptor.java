package com.sproutlemon.admin.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sproutlemon.admin.web.WebConstants;

public class SessionInterceptor implements HandlerInterceptor {

	Logger logger = Logger.getLogger(SessionInterceptor.class);

	final static String[] URL_WHITE_LIST = new String[] { WebConstants.ERROR_PATH, WebConstants.ASSETS_PATH,
			WebConstants.LOGIN_PATH, WebConstants.LOGOUT_PATH };// 无需登录，允许访问的地址

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.info("进入拦截器:::SessionInterceptor.preHandle()");

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String requestUrl = request.getRequestURL().toString();// 获取请求地址
		logger.info("拦截的地址是:::" + requestUrl);

		Object sysAccount = request.getSession().getAttribute(WebConstants.SYS_ACCOUNT_SESSION_KEY);// 获得session中的用户

		for (String url : URL_WHITE_LIST) {
			if (requestUrl.contains(url)) {
				logger.info("拦截结果是:::放行!");// 放行白名单中的地址
				return true;
			}
		}
		String rediretUrl = request.getContextPath() + WebConstants.LOGIN_PATH + "?requestUrl=" + requestUrl;// 跳转的地址
		if (sysAccount == null) {
			response.sendRedirect(rediretUrl);
			logger.info("拦截结果是:::拦截!跳转到:::" + rediretUrl);
			return false;
		}

		return true;

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("SessionInterceptor.postHandle()");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("SessionInterceptor.afterCompletion()");
	}

}
