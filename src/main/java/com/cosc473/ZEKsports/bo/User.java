package com.cosc473.ZEKsports.bo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {

	private String userName;
	private byte[] password;
	private byte[] salt;

	public User(String userName, byte[] password, byte[] salt) {
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

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public byte[] getSalt() {
		return salt;
	}

}
