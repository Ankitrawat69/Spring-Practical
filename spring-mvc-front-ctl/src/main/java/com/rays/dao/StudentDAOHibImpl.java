package com.rays.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.StudentDTO;
import com.rays.dto.UserDTO;

@Repository
public class StudentDAOHibImpl implements StudentDAOInt {
	
	@Autowired
	private SessionFactory sessionFactory = null;

	@Override
	public long add(StudentDTO dto) {
		
		Session session = sessionFactory.getCurrentSession();
	    Long pk = (Long) session.save(dto);
	    return pk;
	}

	@Override
	public void delete(long pk) {
		
		Session session = sessionFactory.getCurrentSession();
		StudentDTO dto = findByPk(pk);
		session.delete(dto);
	}

	@Override
	public void update(StudentDTO dto) {
		sessionFactory.getCurrentSession().update(dto);
	}

	@Override
	public StudentDTO findByPk(long pk) {
		Session session = sessionFactory.getCurrentSession();
        StudentDTO dto = session.get(StudentDTO.class, pk);
		return dto;
	}

	@Override
	public StudentDTO findByLogin(String login) {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(StudentDTO.class,login);
		cr.add(Restrictions.eq("login", login));
		List list = cr.list();
		StudentDTO dto = null;
		if(list.size()==1) {
		dto = (StudentDTO) list.get(0);
		}
		return dto;
	}

	@Override
	public StudentDTO authenticate(String login, String password) {
		Session session = sessionFactory.getCurrentSession();
		StudentDTO dto = null;
		org.hibernate.Query q = session.createQuery("from StudentDTO where login = ? and password = ?");
		q.setString(0,login);
		q.setString(1,password);
		List list = q.list();
		if (list.size() > 0) {
			dto = (StudentDTO) list.get(0);

		} else {
			dto = null;
		}
		return dto;
	}

	@Override
	public List<StudentDTO> search(StudentDTO dto, int pageNo, int pageSize) {
		List<StudentDTO> list = null;
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(StudentDTO.class);
		if (dto != null) {
			if (dto.getStudentName() != null && dto.getStudentName().length() > 0) {
				cr.add(Restrictions.ilike("studentName", dto.getStudentName() + "%"));

			}
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				cr.setFirstResult(pageNo);
				cr.setMaxResults(pageSize);
			}

		}
		list = cr.list();

		return list;
	}

}
