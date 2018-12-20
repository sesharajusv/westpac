package com.developerstack.controller;

import com.developerstack.model.UserDetails;
import com.developerstack.test.config.TestBeanConfig;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestBeanConfig.class})
public class UserControllerTest {
	
	@Autowired
	private UserController userController;

	@Test
	public void validateUser_Test_Positive() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("email", "admin@admin.com");
		params.put("password","admin");
		ResponseEntity result =  userController.validate(new Gson().toJson(params));
		assertNotNull(result);
		assertEquals(result.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void userDetails_Test() {

		ResponseEntity<List<UserDetails>> result =  userController.userDetails();
		assertNotNull(result);
		assertTrue(result.getBody().size() > 0);
	}

}
