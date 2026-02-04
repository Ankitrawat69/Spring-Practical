package com.rays.lifecycle;

public class MyBean {
	
	public void init() {
		
		System.out.println("MyBean bean is created");	
	}
	
	public void destroy() {
		
		System.out.println("MyBean container is close");
		
	}
}
