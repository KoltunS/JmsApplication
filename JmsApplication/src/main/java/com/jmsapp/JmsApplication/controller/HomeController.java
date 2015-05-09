package com.jmsapp.JmsApplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(value="/")
	public String test() {
		logger.info("Returning index.jsp");
		return "index";
	}
	
	@RequestMapping(value="/get", method=RequestMethod.GET)
	@ResponseBody
	public User get(){
		User u = userDao.getUser(1);
		return u;
	}
}
