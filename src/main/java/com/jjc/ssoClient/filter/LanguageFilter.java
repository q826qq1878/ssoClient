package com.jjc.ssoClient.filter;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//jjc 20171228
public class LanguageFilter implements HandlerInterceptor {
	private final static Logger logger = Logger.getLogger(LanguageFilter.class);

	@Resource(name="localeResolver")
	CookieLocaleResolver resolver;


	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String path = request.getServletPath();
		logger.info("拦截到：" + path + ",Filter is request!");

		String language = request.getParameter("language");
		if(!StringUtils.isEmpty(language)){
			language=language.toLowerCase();
			if(language.equals("zh_cn")){
				resolver.setLocale(request, response, Locale.CHINA );
			}else if(language.equals("en")){
				resolver.setLocale(request, response, Locale.ENGLISH );
			}else if(language.equals("ko")){
				resolver.setLocale(request, response, Locale.KOREAN);
			}
		}

		return true;
	}

}
