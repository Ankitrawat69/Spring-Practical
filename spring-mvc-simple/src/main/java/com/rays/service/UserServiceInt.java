package com.rays.service;

import java.util.List;

import com.rays.dto.UserDTO;

public interface UserServiceInt {
	
	public long add(UserDTO dto);
	
	public void delete(long pk);
	
	public void update(UserDTO dto);
	
	public UserDTO findByPk(long pk);
	
	public UserDTO findByLogin(String login);
	
	public UserDTO authenticate(String login, String password);
	
	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize);

}
