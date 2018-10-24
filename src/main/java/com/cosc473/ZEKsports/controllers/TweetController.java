package com.cosc473.ZEKsports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosc473.ZEKsports.services.TweetService;

@CrossOrigin
@RestController
public class TweetController {

	@Autowired
	private TweetService tweetService;

	@RequestMapping(value = "/tweets")
	public ResponseEntity<?> getAllTweets() {
		return ResponseEntity.ok(tweetService.getAllTweets());
	}

	@RequestMapping(value = "/tweets/{number}")
	public ResponseEntity<?> getMostRecent(@PathVariable("number") String number) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(tweetService.getMostRecent(number));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
}
