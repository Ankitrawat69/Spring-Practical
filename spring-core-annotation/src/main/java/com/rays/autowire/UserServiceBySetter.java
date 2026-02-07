package com.rays.autowire;

import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceBySetter {

	private UserDAOInt userDao;

	@Autowired
	public void setUserDao(UserDAOInt userDao) {
		this.userDao = userDao;
	}

	public void testAdd() {
		userDao.add();
	}

}