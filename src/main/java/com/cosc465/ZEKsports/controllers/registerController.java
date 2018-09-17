package com.cosc465.ZEKsports.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class registerController {

	@RequestMapping(value = "/user/register", method= RequestMethod.POST)
	public String createUser(@RequestBody Map<String, String> payload) {
		System.out.println(payload.toString());
		return payload.toString();
	}
}
