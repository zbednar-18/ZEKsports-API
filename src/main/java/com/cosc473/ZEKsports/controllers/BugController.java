package com.cosc473.ZEKsports.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cosc473.ZEKsports.services.BugService;

@RestController
@CrossOrigin
@RequestMapping(value = "/bug")
public class BugController {
	
	@Autowired
	private BugService bugService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> createBug(@RequestBody Map<String, String> payload) {
		if(bugService.createBug(payload).equals("created")) {
			return ResponseEntity.ok("Bug Created");
		} 
		return ResponseEntity.badRequest().body("Bad Request");
	}
}
