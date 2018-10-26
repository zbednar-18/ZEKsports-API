package com.cosc473.ZEKsports.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosc473.ZEKsports.bo.Email;
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
		emailLoad.put("body",
				"Hello " + user.getUserName() + "!<br><br>" + "This email is to confirm your registration to ZEKsports.<br><br>"
						+ "<a href=" + createVerifyUrl(user.getUserEmail(), user.getId()) + ">Click here to confirm your email address</a><br><br>" + "Best, <br><br>The ZEKsports dev team");
		Email email = emailService.createEmail(emailLoad);
		emailService.sendEmail(email);
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

	public String createVerifyUrl(String toAddress, String userId) throws Exception {
		String url = "";
		try {
			url = "http://localhost:3322/user/verify/userId/" + userId + "/toAddress/" + toAddress;
		} catch (Exception e) {
			throw new Exception("Unable to create verify url, email or userId null: " + e.getMessage());
		}
		return url;
	}

	public void verifyUser(String userId, String toAddress) throws Exception {
		User user = userRepository.findByuserEmail(toAddress);
		if (!user.getId().equals(userId)) {
			throw new Exception("Unable to verify user");
		} else {
			user.setVerified(true);
			userRepository.save(user);
		}
	}
}