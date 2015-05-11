package com.jmsapp.JmsApplication.dao;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Repository;

import com.jmsapp.JmsApplication.model.User;

@Repository
public class UserDao {
	private static Logger logger = Logger.getLogger(UserDao.class.getName());
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	public User getUser(int id){
		return em.find(User.class, id);
	}
	
	public List<User> getAll(){
		return em.createQuery("From User").getResultList();
	}
	
	@Transactional
	public void createUser(User user){
		em.persist(user);
		final User u = user;	
		
		MessageCreator mc = new MessageCreator(){
			@Override
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage om = session.createObjectMessage();
				om.setObject(u);
				return om;
			}
		};
		
		jmsTemplate.send(mc);
	}
	
	@Transactional
	public User deleteUser(int id){
		User u = getUser(id);
		em.remove(u);
		return u;
	}
	
}
