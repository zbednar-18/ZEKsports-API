package com.cosc473.ZEKsports.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cosc473.ZEKsports.bo.Tweet;

@Repository
public interface TweetRepository extends MongoRepository<Tweet, String> {

}
