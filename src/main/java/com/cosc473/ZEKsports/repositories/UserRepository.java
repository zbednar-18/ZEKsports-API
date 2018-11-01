package com.cosc473.ZEKsports.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cosc473.ZEKsports.bo.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	public User findByuserName(String userName);
	public User findByuserEmail(String userEmail);
}
