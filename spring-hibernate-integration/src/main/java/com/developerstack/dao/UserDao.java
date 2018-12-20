package com.developerstack.dao;

import java.util.List;

import com.developerstack.model.UserDetails;

public interface UserDao {
	
	UserDetails findUserByEmail(String email);
	List<UserDetails> getUserDetails();

}
