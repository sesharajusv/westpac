/**
 * 
 */
package com.developerstack.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.developerstack.model.UserDetails;

public interface UserService {

	UserDetails validateUser(Map<String, String> user);

	List<UserDetails> getUserDetails();

}
