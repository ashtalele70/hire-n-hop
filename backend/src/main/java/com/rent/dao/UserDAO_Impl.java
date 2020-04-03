package com.rent.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rent.model.User;

@Repository
public class UserDAO_Impl implements UserDAO {
	
	@Autowired
	private EntityManager entityManager; 
	
	@Override
	public List<User> get() {		
		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> query = currentSession.createQuery("from User", User.class);
		List<User> list = query.getResultList();
		return list;
	}

	@Override
	public User get(String email) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<User> query = currentSession.createQuery("from User where email = :email ", User.class);
		query.setParameter("email", email);
		User user = query.uniqueResult();	
		return user;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		user.setIsActive(true);
		currentSession.save(user);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
}
