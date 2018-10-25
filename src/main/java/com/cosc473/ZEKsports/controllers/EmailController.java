package com.cosc473.ZEKsports.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cosc473.ZEKsports.services.EmailService;

@RestController
@CrossOrigin
@RequestMapping(value = "/email")
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createEmail(@RequestBody Map<String, String> payload) throws Exception{
		try {
		emailService.createEmail(payload);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body("OK");
	}
}
