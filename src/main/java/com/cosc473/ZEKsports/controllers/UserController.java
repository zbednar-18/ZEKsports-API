package com.cosc473.ZEKsports.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.cosc473.ZEKsports.bo.User;
import com.cosc473.ZEKsports.repositories.UserRepository;
import com.cosc473.ZEKsports.utils.Password;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@CrossOrigin()
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/register")
	@ResponseBody
	public String createUser(@RequestBody Map<String, String> payload) {
		if (userRepository.findByuserName(payload.get("userName")) == null) {
			byte[] salt = Password.getNextSalt();
			byte[] securePassword = Password.hash(payload.get("password").toCharArray(), salt);
			userRepository.save(new User(payload.get("userName"), securePassword, salt, payload.get("teamSubscription")));
			return payload.get("userName");
		}
		System.out.println("Username already exists");
		return "username already exists";
	}

	@RequestMapping(value = "/login")
	@ResponseBody
	public User loginUser(@RequestBody Map<String, String> payload) {
		User user = null;
		try {
		user = userRepository.findByuserName(payload.get("userName"));
		} catch(Exception e) {
			throw e;
		}
		char[] passwordArray = (payload.get("password").toCharArray());
		byte[] salt = user.getSalt();
		byte[] password = user.getPassword();
		if (Password.isExpectedPassword(passwordArray, salt, password)) {
			System.out.println("logged in");
			return user;
		}
		System.out.println("not logged in");
		return null;
	}
}
