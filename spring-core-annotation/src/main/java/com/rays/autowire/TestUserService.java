package com.rays.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.rays.AppConfig;

public class TestUserService {
	
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		UserServiceByName userService = context.getBean(UserServiceByName.class);
		
		userService.testAdd();

	}
}