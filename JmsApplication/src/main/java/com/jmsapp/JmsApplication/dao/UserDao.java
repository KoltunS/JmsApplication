package com.jmsapp.JmsApplication.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.jmsapp.JmsApplication.model.User;

@Repository
public class UserDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public User getUser(int id){
		return em.find(User.class, id);
	}
}
