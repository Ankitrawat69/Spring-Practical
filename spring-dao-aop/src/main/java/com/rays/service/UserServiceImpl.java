package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

@Service
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	private UserDAOInt dao = null;

	public long add(UserDTO dto) {
		long pk = dao.add(dto);
		return pk;
	}

	public void update(UserDTO dto) {
		dao.update(dto);
	}

	public UserDTO findByPk(long pk) {
		return dao.findByPk(pk);
	}

	public void delete(long pk) {
		dao.delete(pk);
	}

	public UserDTO findByLogin(String login) {
		return dao.findByLogin(login);
	}

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}
}
