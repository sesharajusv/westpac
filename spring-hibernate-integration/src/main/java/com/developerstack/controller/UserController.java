package com.developerstack.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.developerstack.model.UserDetails;
import com.developerstack.service.UserService;
import com.google.gson.Gson;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public ResponseEntity validate(@RequestBody String userString) {
        Map<String, String> user = new Gson().fromJson(userString, Map.class);
		userService.validateUser(user);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public ResponseEntity<List<UserDetails>> userDetails() {
        
		List<UserDetails> userDetails = userService.getUserDetails();
		return new ResponseEntity<List<UserDetails>>(userDetails, HttpStatus.OK);
	}

}
