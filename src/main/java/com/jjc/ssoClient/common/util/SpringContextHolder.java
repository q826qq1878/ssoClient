package com.jjc.ssoClient.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextHolder implements ApplicationContextAware {
	private static ApplicationContext context;
	
	public void setApplicationContext(ApplicationContext ctx)throws BeansException {
		context=ctx;
	}
	
	public static ApplicationContext getApplicationContext(){
		return context;
	}
	
	public static <T> T getBean(Class<T> clazz) {
		if(context == null) {
			throw new IllegalStateException("尚未初始化spring context");
		}
		
		return context.getBean(clazz);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		if(context == null) {
			throw new IllegalStateException("尚未初始化spring context");
		}
		
		return (T) context.getBean(name);
	}
}