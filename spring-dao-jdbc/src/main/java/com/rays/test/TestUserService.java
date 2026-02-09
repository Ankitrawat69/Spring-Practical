package com.rays.test;

import java.util.Iterator;
import java.util.List;

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

//		test.testAdd();
//		test.testDelete();
//		test.testUpdate();
		test.testSearch();
//		test.testAuthenticate();
//		test.testFindByLogin();
//		test.testFindByPk();
	}

	public void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setFirstName("Ankit");
		dto.setLastName("Rawat");
		dto.setLogin("ankit123@gmail.com");
		dto.setPassword("ankit123");
		long pk = service.add(dto);
		System.out.println("Data Inserted successfully.. pk = " + pk);
	}
	
	private void testDelete() {
		service.delete(2);
	}

	private void testUpdate() {
		UserDTO dto = new UserDTO();
		dto.setId(1);
		dto.setFirstName("Ram");
		dto.setLastName("Sharma");
		dto.setLogin("ram@gmail.com");
		dto.setPassword("ram123");
		service.update(dto);
	}
	
	private void testauthenticate() {
		UserDTO dto = service.authenticate("ankit@gmail.com", "ankit123");
		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getLogin());
		System.out.println(dto.getPassword());
		
	}
	
	private void testFindByLogin() {
		UserDTO dto = service.findByLogin("ankit@gmail.com");
		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getLogin());
		System.out.println(dto.getPassword());
	}
	
	private void testFindByPk() {
		UserDTO dto = service.findByPk(1);
		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getLogin());
		System.out.println(dto.getPassword());
	}
	private void testSearch() {
		UserDTO dto = new UserDTO();

		int pageNo = 1;
		int pageSize = 5;

		dto.setFirstName("Ankit");

		List<UserDTO> list = service.search(dto, pageNo, pageSize);

		Iterator<UserDTO> it = list.iterator();
		while (it.hasNext()) {
			dto = it.next();
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPassword());
		}
	}
}