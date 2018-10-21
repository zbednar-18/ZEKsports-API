package com.cosc473.ZEKsports.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.cosc473.ZEKsports.bo.User;
import com.cosc473.ZEKsports.services.UserService;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@CrossOrigin()
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register")
	@ResponseBody
	public ResponseEntity<?> createUser(@RequestBody Map<String, String> payload) {
		String userName = "";
		try {
			userName = userService.createUser(payload);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(userName);
	}

	@RequestMapping(value = "/login")
	@ResponseBody
	public ResponseEntity<?> loginUser(@RequestBody Map<String, String> payload) {
		User user = null;
		try {
			user = userService.loginUser(payload);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(user.getTeamSubscription());
	}
}
