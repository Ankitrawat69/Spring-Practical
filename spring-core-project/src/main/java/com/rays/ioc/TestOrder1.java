package com.rays.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrder1 {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("order1.xml");

		Order1 order = context.getBean("order", Order1.class);

		order.BookTicket(5);

	}
}