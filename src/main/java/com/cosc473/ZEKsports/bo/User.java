package com.cosc473.ZEKsports.bo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {

	@Id
	private String id;

	private String userName;
	private byte[] password;
	private String userEmail;
	private byte[] salt;
	private String teamSubscription;
	private boolean verified;

	public User(String userName, byte[] password, String userEmail, byte[] salt, String teamSubscription) {
		this.userName = userName;
		this.password = password;
		this.userEmail = userEmail;
		this.salt = salt;
		this.teamSubscription = teamSubscription;
		verified = false;
	}

	public User() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public String getTeamSubscription() {
		return teamSubscription;
	}

	public void setTeamSubscription(String teamSubscription) {
		this.teamSubscription = teamSubscription;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	
}
