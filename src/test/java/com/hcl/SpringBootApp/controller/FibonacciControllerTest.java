package com.hcl.SpringBootApp.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.SpringBootApp.controller.FibonacciController;
import com.hcl.SpringBootApp.service.FibonacciService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FibonacciControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private FibonacciController controller;

	@InjectMocks
	private FibonacciService fibonnaciService;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	private String num = "10";

	@Test(expected=NumberFormatException.class)
	public void testFibonacciNumberSuccess() 
	{
		assertEquals(55, fibonnaciService.fibonacci(10));
	}

	@Test(expected=NumberFormatException.class)
	public void testFibonacciNumberFails()
	{
		assertNotEquals(122, fibonnaciService.fibonacci(10));
	}

	@Test
	public void testSuccessfulfibonacci() throws Exception {
		mockMvc.perform(get("/api/Fibonacci").param("n", num)).andExpect(status().is(200));
	}

	@Test
	public void testFailsIfInvalid() throws Exception {
		mockMvc.perform(get("/api/Fibonacci").param("abc", "num")).andExpect(status().is(400));
	}

}
