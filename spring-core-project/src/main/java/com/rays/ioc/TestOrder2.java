package com.rays.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrder2 {
	
	public static void main(String[] args) {
		
		ApplicationContext con = new ClassPathXmlApplicationContext("order2.xml");
		
		Order2 order = con.getBean("order", Order2.class);

		order.BookTicket(7);

	}

}
