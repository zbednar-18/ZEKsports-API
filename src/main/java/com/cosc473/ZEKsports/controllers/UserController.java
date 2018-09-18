package com.cosc473.ZEKsports.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.cosc473.ZEKsports.bo.User;
import com.cosc473.ZEKsports.repositories.UserRepository;
import com.cosc473.ZEKsports.utils.Password;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
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
		
		//TODO: add validation feature, ensure the email submitted is valid.
		if (userRepository.findByuserName(payload.get("userName")) == null) {
			byte[] salt = Password.getNextSalt();
			byte[] securePassword = Password.hash(payload.get("userName").toCharArray(), salt);
			userRepository.save(new User(payload.get("userName"), Base64Utils.encodeToString(securePassword), salt));
			System.out.println("record inserted into collection");
			return "record inserted into collection";
		} else {
			System.out.println("username already exists");
			return "username already exists";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User loginUser(@RequestBody Map<String, String> payload) {
		User user = userRepository.findByuserName(payload.get("userName"));
		if (Password.isExpectedPassword(payload.get("password").toCharArray(), user.getSalt(),
				Base64Utils.decodeFromString(user.getPassword()))) {
			System.out.println("it worked");
			return user;
		} else {
			System.out.println("no bueno");
			return null;
		}
	}
}
