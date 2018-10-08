package com.cosc473.ZEKsports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosc473.ZEKsports.bo.Tweet;
import com.cosc473.ZEKsports.repositories.TweetRepository;

@CrossOrigin
@RestController
@RequestMapping(value = "/nfl")
public class TweetController {

	@Autowired
	private TweetRepository tweetRepository;

	@RequestMapping(value = "/tweets")
	public List<Tweet> getAllTweets() {
		return tweetRepository.findAll();
	}

	@RequestMapping(value = "/tweets/{number}")
	public List<Tweet> getMostRecent(@PathVariable("number") String number) {
		List<Tweet> tweets = new ArrayList<Tweet>();
		List<Tweet> dbTweets = tweetRepository.findAll();

		for (int i = 0; i < Integer.parseInt(number); i++) {
			tweets.add(dbTweets.get(i));
		}
		
		return tweets;
	}
}
