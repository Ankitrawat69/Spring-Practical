package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.StudentDAOInt;
import com.rays.dto.StudentDTO;
import com.rays.dto.UserDTO;

@Service
public class StudentService implements StudentServiceInt{
	
	@Autowired
	private StudentDAOInt dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(StudentDTO dto) {
		
		StudentDTO existDto = dao.findByLogin(dto.getLogin());

        if (existDto != null) {
            throw new RuntimeException("Email already exists");
        }
		long pk = dao.add(dto);
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long pk) {
		
		dao.delete(pk);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(StudentDTO dto) {
		
        StudentDTO existDto = findByLogin(dto.getLogin());
		
		if (existDto != null && existDto.getId() != dto.getId()) {
			throw new RuntimeException("Login ID already exists");
			
		}
		dao.update(dto);
		
	}

	@Transactional(readOnly = true)
	public StudentDTO findByPk(long pk) {
		return dao.findByPk(pk);

	}

	@Transactional(readOnly = true)
	public StudentDTO findByLogin(String login) {
		return dao.findByLogin(login);
	}

	@Transactional(readOnly = true)
	public StudentDTO authenticate(String login, String password) {
		return dao.authenticate(login, password);

	}

	@Transactional(readOnly = true)
	public List<StudentDTO> search(StudentDTO dto, int pageNo, int pageSize) {
		return dao.search(dto, pageNo, pageSize);
	}
	
	

}
