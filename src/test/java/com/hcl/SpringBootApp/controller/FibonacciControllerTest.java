package com.hcl.SpringBootApp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.security.InvalidParameterException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.hcl.SpringBootApp.exceptionHandler.InvalidRequestException;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FibonacciControllerTest {

	@Autowired
	FibonacciController itsFibonacciControllerTest;
	
	@Autowired 
	private MockMvc itsMockMvc;
	
	private long num = 10;
	
	@Test
    public void testSuccessStatusOkForValidInput() throws Exception {
       
		itsFibonacciControllerTest.getNthFibonacciNumber(num)
		.getStatusCode().compareTo(HttpStatus.OK);
	}
	
	@Test(expected=InvalidParameterException.class)
    public void testFailsIfInputStringType() throws Exception {
		itsFibonacciControllerTest.getNthFibonacciNumber(new String("abc"));
	}
	
	@Test
    public void testNthSequenceSuccrss() throws Exception {
       itsMockMvc
            .perform(get("/api/Fibonacci").param("n", "10"))
            .andExpect(status().isOk())
            .andExpect(content().json("55"));
	}
	
	@Test(expected=Exception.class)
    public void testFailsIFInvalidTypeInput() throws Exception {
       itsMockMvc
            .perform(get("/api/Fibonacci").param("n", "abc"))
            .andExpect(status().is(400));
	}
	
	@Test(expected=Exception.class)
    public void testFailsIfNegativeInput() throws Exception {
       itsMockMvc
            .perform(get("/api/Fibonacci").param("n", "-1"))
            .andExpect(status().is(400));
	}
	
	@Test(expected=Exception.class)
    public void testFailsIfInvalidInputObject() throws Exception {
       itsMockMvc
            .perform(get("/api/Fibonacci").param("n", new String("abc")))
            .andExpect(status().is(400));
	}
}
