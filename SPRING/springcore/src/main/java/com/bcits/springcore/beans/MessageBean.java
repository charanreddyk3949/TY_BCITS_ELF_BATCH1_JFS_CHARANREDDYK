package com.bcits.springcore.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
 
// Another way of initialization and destruction phase is implementing InitializingBean & DisposableBean

public class MessageBean implements InitializingBean, DisposableBean {
	public MessageBean() {
		System.out.println("Its Instantiation phase");
	}
	//setters and getters
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Its initialization phase");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Its destruction phase!!!");	
		
	}
	
	
	//init & destoy method(first way for initialization and Destruction phase )
//	public void init() {
//		System.out.println("It's Initialization phase");
//	}
//	public void destroy() {
//	 System.out.println("Its destruction phase!!!");	
//	}

}
