package com.cosc473.ZEKsports.bo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {

	private String userName;
	private String password;
	private byte[] salt;

	public User(String userName, String password, byte[] salt) {
		this.userName = userName;
		this.password = password;
		this.salt = salt;
	}

	public User() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getSalt() {
		return salt;
	}

}
