package com.rays.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAOHibImpl implements UserDAOInt{

	@Autowired
	private SessionFactory sessionFactory = null;

	public long add(UserDTO dto) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Long pk = (Long) session.save(dto);

		return pk;
	}

	public void delete(long pk) {
		
		Session session = sessionFactory.getCurrentSession();
		
		UserDTO dto = findByPk(pk);
		
		session.delete(dto);

	}

	public void update(UserDTO dto) {
		
		sessionFactory.getCurrentSession().update(dto);
	}

	public UserDTO findByPk(long pk) {
		
		Session session = sessionFactory.getCurrentSession();
		
		UserDTO dto = session.get(UserDTO.class, pk);
		
		return dto;
	}

	public UserDTO findByLogin(String login) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(UserDTO.class, login);

		criteria.add(Restrictions.eq("login", login));

		List list = criteria.list();

		UserDTO dto = null;

		if (list.size() == 1) {
			dto = (UserDTO) list.get(0);

		}
		return dto;
	}

	public UserDTO authenticate(String login, String password) {

		Session session = sessionFactory.getCurrentSession();

		UserDTO dto = null;

		org.hibernate.Query q = session.createQuery("from UserDTO where login = ? and password = ?");

		q.setString(0, login);
		q.setString(1, password);

		List list = q.list();

		if (list.size() > 0) {
			dto = (UserDTO) list.get(0);

		} else {
			dto = null;
		}

		return dto;
	}

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		
		List<UserDTO> list = null;

		Session session = sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(UserDTO.class);

		if (dto != null) {
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				criteria.add(Restrictions.ilike("firstName", dto.getFirstName() + "%"));

			}
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}

		}
		list = criteria.list();

		return list;
	}

	


	}