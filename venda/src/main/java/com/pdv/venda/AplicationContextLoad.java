package com.pdv.venda;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;

@Controller
public class AplicationContextLoad implements ApplicationContextAware {

	@Autowired
	private static ApplicationContext applicationcontext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		
		
		this.applicationcontext = applicationContext;
		
	}
	
	 public static ApplicationContext getApplicationcontext() {
		return applicationcontext;
	}

}
