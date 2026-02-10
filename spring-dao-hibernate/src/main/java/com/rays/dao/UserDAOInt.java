package com.rays.dao;

import java.util.List;

import com.rays.dto.UserDTO;

public interface UserDAOInt {

	public long add(UserDTO dto);

	public void update(UserDTO dto);

	public void delete(long pk);

	public UserDTO findByPk(long pk);

	public UserDTO findByLogin(String login);

	public UserDTO authenticate(String login, String password);

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize);

}