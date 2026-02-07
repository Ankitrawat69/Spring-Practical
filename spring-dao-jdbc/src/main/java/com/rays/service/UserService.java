package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

@Service
public class UserService {
	
	private UserDAOInt dao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {
		long pk = dao.add(dto);
		return pk;
	}
}
