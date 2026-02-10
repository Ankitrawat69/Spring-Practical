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
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		 TestUserService test = (TestUserService) context.getBean("testUserService");
		 

//			test.testAdd();
//			test.testUpdate();
//			test.testFindByPk();
//		    test.testDelete();
			test.testFindByLogin();
//		    test.testSearch();
//			test.testAuthenticate();
	}
	
	public void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setFirstName("Danny");
		dto.setLastname("D");
		dto.setLogin("Danny@gmail.com");
		dto.setPassword("Danny123");
		long pk = service.add(dto);
		System.out.println("PK----> " + pk);
	}
	
	private void testSearch() {
		UserDTO dto = new UserDTO();
		  dto.setFirstName("Danny");
		  int pageNo = 1;
		  int pageSize = 5;
		  List<UserDTO> list = service.search(dto, pageNo, pageSize);
		  
		  Iterator<UserDTO> it = list.iterator();
		   while(it.hasNext()) {
			   dto = it.next();
			   System.out.println(dto.getId());
			   System.out.println(dto.getFirstName());
			   System.out.println(dto.getLastname());
			   System.out.println(dto.getLogin());
			   System.out.println(dto.getPassword());
		   }
	}
    
	private void testFindByLogin() {
		UserDTO dto = new UserDTO();
		dto = service.findByLogin("Danny@gmail.com");
		if (dto != null) {
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastname());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPassword());
		} else {
			System.out.println("user not found");
	}
  }
	private void testUpdate() {
		UserDTO dto = new UserDTO();
		dto.setId(1);
		dto.setFirstName("Kamal");
		dto.setLastname("Yadav");
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

	private void testAuthenticate() {
		UserDTO dto = service.authenticate("ram@gmail.com", "ram123");
		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastname());
		System.out.println(dto.getLogin());
		System.out.println(dto.getPassword());
	}
}
	

