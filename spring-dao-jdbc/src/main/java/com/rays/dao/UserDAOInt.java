package com.rays.dao;

import java.util.List;

import com.rays.dto.UserDTO;

public interface UserDAOInt {

	public long nextPk();

	public long add(UserDTO dto);
	
	public void delete(int id);

	public void update(UserDTO dto);
	
	public UserDTO authenticate(String login,String password);
	
	public UserDTO findByLogin(String login);
	
	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize);
	
	public UserDTO findByPk(int id);


}