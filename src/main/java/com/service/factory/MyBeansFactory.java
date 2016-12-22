package com.service.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeansFactory {
	
	private static ApplicationContext ctx=null;
	private static final String springSource="spring/applicationContext.xml";
	
	
	private static void initCTX(){		
		
		if(ctx==null){
			ctx=new ClassPathXmlApplicationContext(springSource);
		}
		
	}
	
	public static Object getBeans(String beanName){
		
		initCTX();

		return ctx.getBean(beanName);
		
	}
	
	
}
