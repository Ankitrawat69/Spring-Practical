package com.rays.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // @Service annotation is use for create Service layer and also create bean
public class UserService {

	@Autowired // @Autowired annotation inject dependency by type
	private UserDAOInt userDao;

	public void testAdd() {
		userDao.add();
	}

}