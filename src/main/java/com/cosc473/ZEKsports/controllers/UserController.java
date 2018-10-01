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
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String createUser(@RequestBody Map<String, String> payload) {
		if (userRepository.findByuserName(payload.get("userName")) == null) {
			byte[] salt = Password.getNextSalt();
			byte[] securePassword = Password.hash(payload.get("userName").toCharArray(), salt);
			userRepository.save(new User(payload.get("userName"), securePassword, salt));
			return payload.get("userName");
		}
		return "username already exists";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public User loginUser(@RequestBody Map<String, String> payload) {
		User user = userRepository.findByuserName(payload.get("userName"));
		if (Password.isExpectedPassword(payload.get("password").toCharArray(), user.getSalt(), user.getPassword())) {
			return user;
		}
		return null;
	}
}
