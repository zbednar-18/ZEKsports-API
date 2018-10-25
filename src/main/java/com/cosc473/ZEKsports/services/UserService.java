package com.cosc473.ZEKsports.services;

import java.util.HashMap;
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

	@Autowired
	private EmailService emailService;
	
	public HashMap<String, String> createUser(Map<String, String> payload) throws Exception {
		User user = userRepository.findByuserName(payload.get("userName"));
		HashMap<String, String> returnLoad = new HashMap<String, String>();
		HashMap<String, String> emailLoad = new HashMap<String, String>();
		if (user != null) {
			throw new Exception("Username is already in use");
		}
		byte[] salt = Password.getNextSalt();
		byte[] securePassword = Password.hash(payload.get("password").toCharArray(), salt);
		user = new User(payload.get("userName"), securePassword, payload.get("email"), salt,
				payload.get("teamSubscription"));
		userRepository.insert(user);
		returnLoad.put("userName", user.getUserName());
		emailLoad.put("toAddress", user.getUserEmail());
		emailLoad.put("subject", "Welcome to ZEKsports");
		emailLoad.put("body", "Hello " + user.getUserName() + "! \n\n "
				+ "This email is to confirm your registration to ZEKsports.\n\n" 
				+ "Best, \n\n The ZEKsports dev team");
		emailService.createEmail(emailLoad);
		return returnLoad;
	}

	public HashMap<String, String> loginUser(Map<String, String> payload) throws Exception {
		User user = userRepository.findByuserName(payload.get("userName"));
		HashMap<String, String> returnLoad = new HashMap<String, String>();
		if (user == null) {
			throw new Exception("Username/Password Combination does not exist");
		}
		char[] passwordArray = (payload.get("password").toCharArray());
		byte[] salt = user.getSalt();
		byte[] password = user.getPassword();
		if (Password.isExpectedPassword(passwordArray, salt, password)) {
			returnLoad.put("userName", user.getUserName());
			returnLoad.put("teamSubscription", user.getTeamSubscription());
			return returnLoad;
		}
		throw new Exception("Username/Password Combination does not exist");
	}
}