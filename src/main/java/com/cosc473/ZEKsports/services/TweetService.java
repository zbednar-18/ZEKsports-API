package com.cosc473.ZEKsports.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cosc473.ZEKsports.bo.Tweet;
import com.cosc473.ZEKsports.repositories.TweetRepository;

@Service
public class TweetService {

	@Autowired
	private TweetRepository tweetRepository;
	
	public List<Tweet> getAllTweets() {
		return tweetRepository.findAll();
	}
	
	public List<Tweet> getMostRecent(@PathVariable("number") String number) throws Exception {
		List<Tweet> tweets = new ArrayList<Tweet>();
		List<Tweet> dbTweets = tweetRepository.findAll();

		for (int i = 0; i < Integer.parseInt(number); i++) {
			tweets.add(dbTweets.get(i));
		}
		if(tweets.isEmpty()) {
			throw new Exception("Unable to fetch tweets");
		}
		return tweets;
	}
}
