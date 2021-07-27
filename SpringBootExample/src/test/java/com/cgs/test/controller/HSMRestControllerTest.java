package com.cgs.test.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.cgs.rest.controller.HsmDetailsRestController;


@SpringBootTest
@WebMvcTest(value = HsmDetailsRestController.class)
public class HSMRestControllerTest {
	
	@Test
	public void test1() {
		System.out.println("first test case");
	}
	
	

}
