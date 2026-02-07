package com.rays.autowire;

import org.springframework.stereotype.Repository;

@Repository("userDao") // @Repository annotation is use for create DAO(CRUD) layer and also create bean
public class UserDAOImpl implements UserDAOInt {

	public void add() {

		System.out.println("add method..!!");

	}

}