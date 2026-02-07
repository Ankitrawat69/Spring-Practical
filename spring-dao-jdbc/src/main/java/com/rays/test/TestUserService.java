package com.rays.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserService;

@Component("testUserService")
public class TestUserService {

	@Autowired
	public UserService service = null;

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("testUserService");

		test.testAdd();

	}

	public void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setFirstName("Ankit");
		dto.setLastName("Rawat");
		dto.setLogin("ankit@gmail.com");
		dto.setPassword("ankit123");
		long pk = service.add(dto);
		System.out.println("Data Inserted successfully.. pk = " + pk);
	}

}