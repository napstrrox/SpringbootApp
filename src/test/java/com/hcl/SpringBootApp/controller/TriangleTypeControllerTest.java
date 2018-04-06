package com.hcl.SpringBootApp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.hcl.SpringBootApp.service.TriangleTypeServices;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TriangleTypeControllerTest {

	@Autowired
	private MockMvc itsMockMvc;

	@Mock
	private TringleTypeController itsTringleTypeControllerTest;

	private int a, b, c = 1;
	@Test(expected=Exception.class)
	public void testSuccessStatusOkWithValidInput() throws Exception {
		itsTringleTypeControllerTest.getTriangleType(a, b, c).getStatusCode().compareTo(HttpStatus.OK);
	}

	@Test
	public void testSuccessForEquilateralTrianglWithValidInpute() throws Exception {
		itsMockMvc.perform(get("/api/TriangleType").param("a", "1").param("b", "1").param("c", "1"))
				.andExpect(status().isOk()).andExpect(content().string(TriangleTypeServices.EQUILATERAL));
	}

	@Test
	public void testSuccessForIsoscelesTriangleWithValidInput() throws Exception {
		itsMockMvc.perform(get("/api/TriangleType").param("a", "2").param("b", "5").param("c", "5"))
				.andExpect(status().isOk()).andExpect(content().string(TriangleTypeServices.ISOSCELES));
	}

	@Test
	public void testSuccessForScaleneTriangleWithValidInput() throws Exception {
		itsMockMvc.perform(get("/api/TriangleType").param("a", "4").param("b", "5").param("c", "6"))
				.andExpect(status().isOk()).andExpect(content().string(TriangleTypeServices.SCALENE));
	}

	@Test(expected=Error.class)
	public void testSuccessForNotATriangleWithValidInput() throws Exception {
		itsMockMvc.perform(get("/api/TriangleType").param("a", "1").param("b", "0").param("c", "3"))
				.andExpect(status().isOk()).andExpect(content().string(TriangleTypeServices.INVALID));
	}

	@Test
	public void testFailsWithInValidInput() throws Exception {
		itsMockMvc.perform(get("/api/TriangleType").param("a", "a").param("b", "b").param("c", "c"))
				.andExpect(status().is(400));
	}

	@Test
	public void testFailsWithNegativeInput() throws Exception {
		itsMockMvc.perform(get("/api/TriangleType").param("a", "-4").param("b", "-3").param("c", "-3"))
				.andExpect(status().is(400));
	}
}
