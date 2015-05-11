package com.jmsapp.JmsApplication.util;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.log4j.Logger;
import com.jmsapp.JmsApplication.model.User;


public class MsgListenerReceiver implements MessageListener{

	private static Logger logger = Logger.getLogger(MsgListenerReceiver.class.getName());
	
	private User receivedUser;
	
	@Override
	public void onMessage(Message message) {
		try
	    {
	        if (message instanceof ObjectMessage)
	        {
	        	receivedUser = (User) ((ObjectMessage) message).getObject();
				logger.info("Received user: "+receivedUser.getFirstname()+" "+receivedUser.getLastname()+" "+receivedUser.getEmail());
	        }
	    }
	    catch (Exception exp)
	    {
	        logger.error("Received message is not an object message!");
	    }
		
	}

}
