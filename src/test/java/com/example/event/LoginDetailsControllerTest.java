package com.example.event;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.event.model.Event;
import com.example.event.model.LoginDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest

public class LoginDetailsControllerTest {
	
	@Autowired
	   WebApplicationContext webApplicationContext;
	
	
	
	@Test
	   public void validateLogin() throws Exception {
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	      String uri = "/login";
	      LoginDetails login = new LoginDetails();
	      login.setUsername("dalia@gmail.com");
	      login.setPassword("Test");
	      login.setRole("admin");
	      String inputJson = mapToJson(login);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();   
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);

	   }
	

	@Test
	   public void createCredentials() throws Exception {
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	      String uri = "/createcred";
	      LoginDetails login = new LoginDetails();
	      login.setUsername("dalia@gmail.com");
	      login.setPassword("Test");
	      login.setRole("admin");
	      String inputJson = mapToJson(login);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();   
	      int status = mvcResult.getResponse().getStatus();
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(200, status);
	      

	   }
	
	
	protected String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	   }

}
