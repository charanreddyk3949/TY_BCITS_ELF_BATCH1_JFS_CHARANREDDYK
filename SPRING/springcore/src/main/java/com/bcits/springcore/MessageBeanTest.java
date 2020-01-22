package com.bcits.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcore.beans.MessageBean;

public class MessageBeanTest {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		((ConfigurableApplicationContext)context).registerShutdownHook();
		MessageBean messageBeanTest = (MessageBean) context.getBean("message");

		System.out.println(messageBeanTest.getMessage());
		
		
//       for close the container
//		((AbstractApplicationContext)context).close();
		
		MessageBean messageBeanTest2 = (MessageBean) context.getBean("message");  //It throws Exception because contex is destroy
		System.out.println(messageBeanTest.getMessage());
	}// End of main

}// End of class
