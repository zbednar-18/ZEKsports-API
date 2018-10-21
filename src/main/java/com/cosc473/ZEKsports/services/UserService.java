package com.cosc473.ZEKsports.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosc473.ZEKsports.bo.User;
import com.cosc473.ZEKsports.repositories.UserRepository;
import com.cosc473.ZEKsports.utils.Password;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public String createUser(Map<String, String> payload) throws Exception {
		User user = userRepository.findByuserName(payload.get("userName"));
		if (user != null) {
			throw new Exception("Username is already in use");
		}
		byte[] salt = Password.getNextSalt();
		byte[] securePassword = Password.hash(payload.get("password").toCharArray(), salt);
		user = new User(payload.get("userName"), securePassword, salt, payload.get("teamSubscription"));
		userRepository.insert(user);
		return user.getUserName();
	}

	public User loginUser(Map<String, String> payload) throws Exception {
		User user = userRepository.findByuserName(payload.get("userName"));
		if (user == null) {
			throw new Exception("Username/Password Combination does not exist");
		}
		char[] passwordArray = (payload.get("password").toCharArray());
		byte[] salt = user.getSalt();
		byte[] password = user.getPassword();
		if (Password.isExpectedPassword(passwordArray, salt, password)) {
			return user;
		}
		throw new Exception("Username/Password Combination does not exist");
	}
}