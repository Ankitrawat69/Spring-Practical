package com.rays.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyBeanLifeCycle {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("lifecycle.xml");

		MyBean bean = context.getBean("mybean", MyBean.class);
		
		((ClassPathXmlApplicationContext) context).close();

	}

}