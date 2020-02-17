package com.example.demo;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@WebMvcTest(DemoApplication.class)
class DemoApplicationTests {

	private static final String ROOT_URL = "";
	private static final String HELLO_WORLD = "Hello World!";
	@Autowired
	private MockMvc mvc;

	@Test
	public void contextLoads() throws Exception {
		MvcResult result = mvc.perform(get(ROOT_URL)).andReturn();
		String s = result.getResponse().getContentAsString();
		assertTrue(s.equals(HELLO_WORLD));
	}

}
