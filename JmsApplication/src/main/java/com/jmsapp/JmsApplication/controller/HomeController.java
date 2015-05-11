package com.jmsapp.JmsApplication.controller;


import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jmsapp.JmsApplication.dao.UserDao;
import com.jmsapp.JmsApplication.model.User;

@Controller
public class HomeController {
	private static Logger logger = Logger.getLogger(HomeController.class.getName());

	@Autowired
	UserDao userDao;

	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String getIndex()  {
		return "index";
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	@ResponseBody
	public User createUser(@Valid @RequestBody User user){
		logger.info("Creating user");
		userDao.createUser(user);
		return user;
	}
	
	@RequestMapping(value = "/all", method=RequestMethod.GET)
	@ResponseBody
	public List<User> getAllUsers() {
		return userDao.getAll();
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Object> deleteUser(@PathVariable final int id){
		User u = userDao.deleteUser(id); 
		return new ResponseEntity<Object>(u,HttpStatus.OK);
	}
	
}
