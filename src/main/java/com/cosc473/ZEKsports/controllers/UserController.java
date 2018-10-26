package com.cosc473.ZEKsports.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.cosc473.ZEKsports.services.UserService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@CrossOrigin()
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> createUser(@RequestBody Map<String, String> payload) throws Exception {
		HashMap<String, String> returnLoad;
		try {
			returnLoad = userService.createUser(payload);
		} catch (Exception e) {
			throw e;
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(returnLoad);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> loginUser(@RequestBody Map<String, String> payload) {
		Map<String, String> returnLoad = null;
		try {
			returnLoad = userService.loginUser(payload);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(returnLoad);
	}
	
	@RequestMapping(value = "/verify/userId/{userId}/toAddress/{toAddress}", method=RequestMethod.GET) 
	public ResponseEntity<?> verifyUser(@PathVariable("userId") String userId, @PathVariable("toAddress") String toAddress ) throws Exception {
		try {
			userService.verifyUser(userId, toAddress);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request: " + e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body("You are verified!<br>" 
				+ "<a href=http://localhost/cosc473/zeksports/index.html> Login on our website! </a>");
	}
}
