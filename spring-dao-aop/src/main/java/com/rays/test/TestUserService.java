package com.rays.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {

	@Autowired
	public UserServiceInt service = null;

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("testUserService");

		test.testAdd();
//		test.testUpdate();
//		test.testFindByPk();
//		test.testDelete();
//		test.testFindByLogin();
//		test.testSearch();

	}

	private void testSearch() {
		UserDTO dto = new UserDTO();
		dto.setFirstName("Ankit");
		int pageNo = 1;
		int pageSize = 5;
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

	private void testFindByLogin() {
		UserDTO dto = new UserDTO();
		dto = service.findByLogin("shyam@gmail.com");
		if (dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPassword());
		} else {
			System.out.println("user not found");
		}

	}

	public void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setFirstName("Ram");
		dto.setLastName("Yadav");
		dto.setLogin("ram@gmail.com");
		dto.setPassword("ram123");
		long pk = service.add(dto);
		System.out.println("PK----> " + pk);
	}

	private void testUpdate() {
		UserDTO dto = new UserDTO();
		dto.setId(2);
		dto.setFirstName("Kamal");
		dto.setLastName("Yadav");
		dto.setLogin("ram@gmail.com");
		dto.setPassword("ram123");
		service.update(dto);
	}

	private void testFindByPk() {
		UserDTO dto = service.findByPk(2);
		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
	}

	private void testDelete() {
		service.delete(2);
	}
}