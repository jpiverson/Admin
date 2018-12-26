package com.sproutlemon.admin.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sproutlemon.admin.web.WebConstants;

@Controller
public class IndexController extends AdminController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(HttpServletRequest request, ModelMap model, String requestUrl) {

		return "redirect:" + WebConstants.INDEX_PATH;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String login(HttpServletRequest request, String account, String password) {

		return "error";

	}

}
