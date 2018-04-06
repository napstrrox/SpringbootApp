package com.hcl.SpringBootApp.controller;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.BDDMockito.given;
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
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.SpringBootApp.controller.ReverseWordController;
import com.hcl.SpringBootApp.service.ReverseWordService;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ReverseWordsControllerTest {

private String sentence = "How are you";
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private ReverseWordController reverseWordsController;
	
	@InjectMocks
	private ReverseWordService reverseWordsService;
	
	@Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(reverseWordsController)
                .build();
    }
	
	@Test
	public void testSuccessfulWordsReversal() throws Exception {
		mockMvc.perform(get("/api/ReverseWords").param("sentence", sentence))
		.andExpect(status().isOk());
	}
	
	@Test
	public void testFailureScenario() throws Exception {
		assertNotEquals("test",reverseWordsService.reverseWord(sentence));
	}
	
}
