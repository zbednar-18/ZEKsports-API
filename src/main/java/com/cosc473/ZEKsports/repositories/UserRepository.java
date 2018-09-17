package com.cosc473.ZEKsports.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cosc473.ZEKsports.bo.User;

public interface UserRepository extends MongoRepository<User, String> {

	public User findByuserName(String userName);
}
