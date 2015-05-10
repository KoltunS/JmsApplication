package com.jmsapp.JmsApplication.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.jmsapp.JmsApplication.model.User;

@Repository
public class UserDao {
	private static Logger logger = Logger.getLogger(UserDao.class.getName());
	
	@PersistenceContext
	private EntityManager em;
	
	public User getUser(int id){
		return em.find(User.class, id);
	}
	
	public List<User> getAll(){
		return em.createQuery("From User").getResultList();
	}
	
	@Transactional
	public void createUser(User user){
		logger.info("Saving user "+user.getFirstname()+" "+user.getLastname()+" to DB");
		em.persist(user);
	}
	
	@Transactional
	public User deleteUser(int id){
		User u = getUser(id);
		em.remove(u);
		return u;
	}
	
}
