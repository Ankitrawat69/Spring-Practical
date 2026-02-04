package com.rays.autowire.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrder1 {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("autowire-byname.xml");

		Order1 order = context.getBean("order", Order1.class);

		order.BookTicket(3);

	}
}