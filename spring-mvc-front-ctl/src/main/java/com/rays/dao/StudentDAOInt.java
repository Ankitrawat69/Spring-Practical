package com.rays.dao;

import java.util.List;

import com.rays.dto.StudentDTO;

public interface StudentDAOInt {
	
	public long add(StudentDTO dto);
	
	public void delete(long pk);
	
	public void update(StudentDTO dto);
	
	public StudentDTO findByPk(long pk);
	
	public StudentDTO findByLogin(String login);
	
	public StudentDTO authenticate(String login, String password);
	
	public List<StudentDTO> search(StudentDTO dto, int pageNo, int pageSize);

}
