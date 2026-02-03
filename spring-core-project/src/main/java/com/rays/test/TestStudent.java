package com.rays.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestStudent {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("student.xml");
		
		Student dto = (Student) context.getBean("student");
		
		System.out.println(dto.getName());
		System.out.println(dto.getAddress());
		System.out.println(dto.getRollno());
	}
}
