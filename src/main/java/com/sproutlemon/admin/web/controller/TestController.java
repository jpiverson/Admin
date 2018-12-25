package com.sproutlemon.admin.web.controller;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sproutlemon.admin.entity.sys.SysRegion;
import com.sproutlemon.admin.service.sys.SysRegionService;

@RestController
@RequestMapping("/test")
public class TestController extends AdminController {

	@Autowired
	SysRegionService regionService;

	@RequestMapping("/index")
	public String index(ServletRequest reqeust, String name) {

		String ipaddr = reqeust.getRemoteAddr();

		logger.info("the request ip add is " + ipaddr);
		return "Hello, " + name;

	}

	@RequestMapping("/jpa")
	public String jpa() {
		List<SysRegion> provinces = regionService.findAllProvince();
		for (SysRegion region : provinces) {
			logger.info(region.getName());
		}
		return "DONE";
	}

	@RequestMapping("/html")
	public ModelAndView html() {
		ModelAndView view = new ModelAndView();
		view.setViewName("index");// 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html
		// 设置属性
		view.addObject("title", "我的第一个WEB页面");
		view.addObject("desc", "欢迎进入battcn-web 系统");
		Author author = new Author();
		author.setAge(32);
		author.setEmail("jipeng117@gmail.com");
		author.setName("Penn");
		view.addObject("author", author);
		return view;
	}

	class Author {
		private int age;
		private String name;
		private String email;

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	}

	public static void main(String[] args) {
		String str = DigestUtils.md5DigestAsHex("123456".getBytes());
		System.out.println(str);
	}

}
