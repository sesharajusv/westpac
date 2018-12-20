/**
 * 
 */
package com.developerstack.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developerstack.dao.UserDao;
import com.developerstack.model.UserDetails;
import com.developerstack.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	public UserDetails validateUser(Map<String, String> user) {
		String email = user.get("email");
		String password = user.get("password");
		
		UserDetails userDetails = userDao.findUserByEmail(email);
		if(userDetails == null || !userDetails.getPassword().equals(password)) {
			throw new RuntimeException("Invalid credentials.");
		}
		return userDetails;
	}

	public List<UserDetails> getUserDetails() {
		return userDao.getUserDetails();

	}

}
