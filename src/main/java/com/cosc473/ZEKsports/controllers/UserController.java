package com.cosc473.ZEKsports.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.cosc473.ZEKsports.bo.User;
import com.cosc473.ZEKsports.repositories.UserRepository;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/user/register", method= RequestMethod.POST)
	public String createUser(@RequestBody Map<String, String> payload) {		
		userRepository.save(new User(payload.get("userName"), payload.get("password")));
		return "record inserted into collection";
	}
	
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public void loginUser(@RequestBody Map<String, String> payload) {
		
	}
}
