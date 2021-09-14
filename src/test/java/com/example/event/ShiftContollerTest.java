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
import com.example.event.model.Shift;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class ShiftContollerTest {
	
	@Autowired
	   WebApplicationContext webApplicationContext;
	
	@Test 
	public void createShift() throws Exception {
		MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	      String uri = "/shift";
	      Shift shift = new Shift();
	    shift.setId(1);
	      shift.setEventId(8);
	      shift.setDescription("day");
	      String inputJson = mapToJson(shift);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();   
	      int status = mvcResult.getResponse().getStatus();
	      String content = mvcResult.getResponse().getContentAsString();
	      Assert.assertTrue(content.contains("day"));
	      assertEquals(200, status);
		
	}
	
	@Test
	   public void getShiftList() throws Exception {
		
	      MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	      String uri = "/Shift";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      
	      String content = mvcResult.getResponse().getContentAsString();
	      System.out.println(content);

	   }
	
	@Test
	   public void updateShiftByEventID() throws Exception {
		Shift shift = new Shift();
	      shift.setId(1);
	      shift.setDescription("Test");
	      String inputJson = mapToJson(shift);
	      MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	      String uri = "/Shift";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	    	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	    	         .content(inputJson)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      
	      String content = mvcResult.getResponse().getContentAsString();
	      System.out.println(content);

	   }
	
	@Test
	   public void deleteShiftByEventID() throws Exception {
		
	      MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	      String uri = "/Shift/1";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)
	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      
	      String content = mvcResult.getResponse().getContentAsString();
	      System.out.println(content);

	   }
	
	protected String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	   }

}
