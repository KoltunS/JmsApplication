package com.jmsapp.JmsApplication.test;


import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.google.gson.Gson;
import com.jmsapp.JmsApplication.model.User;

import static org.hamcrest.Matchers.*;

@ActiveProfiles("tests")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
"file:src/main/webapp/WEB-INF/JMSApplication-servlet.xml",
"file:src/main/webapp/WEB-INF/database-config.xml"
})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class })
@DatabaseSetup("classpath:userData.xml")
@WebAppConfiguration
public class ControllerTest {

	private MockMvc mockMvc;
	private Gson gson;
	@Resource
	WebApplicationContext webApplicationContext; 
	
	@Before
	public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        gson = new Gson();
	}
	
	@Test
	@ExpectedDatabase("classpath:userData.xml")
	public void testGetAll() throws Exception{
		this.mockMvc.perform(get("/all"))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$..idUser").exists())
		.andExpect(jsonPath("$..firstname").exists())
		.andExpect(jsonPath("$..lastname").exists())
		.andExpect(jsonPath("$..email").exists());
	}
	
	@Test
	@ExpectedDatabase("classpath:userCreateData.xml")
	public void testCreateNew() throws Exception{
		User u = new User();
		u.setFirstname("Anna");
		u.setLastname("Kowalska");
		u.setEmail("kowalska@gmail.com");
		
		this.mockMvc.perform(post("/")
				.content(gson.toJson(u))
				.contentType("application/json;charset=UTF-8"))
		.andExpect(status().isOk());
	}
	
	@Test
	@ExpectedDatabase("classpath:userDeleteData.xml")
	public void testDelete() throws Exception{	
		this.mockMvc.perform(delete("/delete/1"))
		.andExpect(status().isOk());
	}
	
}
