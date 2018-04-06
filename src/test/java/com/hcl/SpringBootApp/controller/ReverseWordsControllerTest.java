package com.hcl.SpringBootApp.controller;

import static org.assertj.core.api.Assertions.in;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.AssertionErrors;
import org.springframework.test.web.servlet.MockMvc;

import com.hcl.SpringBootApp.exceptionHandler.InvalidRequestException;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ReverseWordsControllerTest {
	
	@Autowired
	MockMvc itsMockMvc;
	
	@Autowired
	ReverseWordController itsReverseWordControllerTest;
	
	private final String itsInputString = "How Are You";
	
	@Test
	public void testSuccessStatusOkForValidInput() 
	{
		itsReverseWordControllerTest.getReverseWords(itsInputString)
		.getStatusCode().compareTo(HttpStatus.OK);
	}
	
	@Test(expected=JSONException.class)
	public void testSuccessForValidInputString() throws Exception
	{
		itsMockMvc
         .perform(get("/api/ReverseWords").param("sentence",itsInputString))
         .andExpect(status().isOk())
         .andExpect(content().json("woh era uoy"));
	}
	
	@Test(expected=IllegalArgumentException.class)
    public void testFailsIfInputnull() throws Exception {
       itsMockMvc
            .perform(get("/api/ReverseWords").param("sentence",null))
            .andExpect(status().is(400));
	}
	
	@Test
    public void testFailsIfInputEmpty() throws Exception {
       itsMockMvc
            .perform(get("/api/ReverseWords").param("sentence",""))
            .andExpect(status().is(400));
	}
	
}
