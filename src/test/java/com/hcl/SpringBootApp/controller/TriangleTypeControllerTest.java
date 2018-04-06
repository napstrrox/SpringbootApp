package com.hcl.SpringBootApp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.SpringBootApp.controller.TringleTypeController;
import com.hcl.SpringBootApp.service.TriangleTypeServices;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TriangleTypeControllerTest {
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private TringleTypeController triangleTypeController;
	
	@InjectMocks
	private TriangleTypeServices triangleTypeService;
	
	@Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(triangleTypeController)
                .build();
    }
	
	@Test
	public void testSuccessIfValidParameter() throws Exception {
		mockMvc.perform(get("/api/TriangleType").param("a","1").param("b", "1").param("c", "1"))
		.andExpect(status().is(200));
	}
	
	@Test
	public void testFailsIsInValidParameter() throws Exception {
		mockMvc.perform(get("/api/TriangleType").param("a","a").param("b", "1").param("c", "1"))
		.andExpect(status().is(400));
	}
	
}
