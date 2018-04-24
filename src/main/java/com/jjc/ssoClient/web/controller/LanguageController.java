package com.jjc.ssoClient.web.controller;

import java.util.Locale;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

@Controller
public class LanguageController {

	/**
	 * 演示一些消息
	 */
	@RequestMapping("/something.html")
	public String something(){
		System.out.println("other page.");
		return "something";
	}
	
	/**
	 * 换页面
	 */
	@RequestMapping(value="/welcome")  
	public String welcome(){
		return "index";
	}
}
