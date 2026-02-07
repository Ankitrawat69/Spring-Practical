package com.rays.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceByName {

	@Autowired
	@Qualifier("userDao")
	private UserDAOInt userDao;

	public void testAdd() {
		userDao.add();
	}

}