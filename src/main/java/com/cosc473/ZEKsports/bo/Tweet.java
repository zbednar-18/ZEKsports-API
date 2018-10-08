package com.cosc473.ZEKsports.bo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Tweet")
public class Tweet {

	private String createdOn;
	private String text;
	private String screenName;
	private String name;

	public Tweet() {
	}

	public Tweet(String createdOn, String text, String screenName, String name) {
		this.createdOn = createdOn;
		this.text = text;
		this.screenName = screenName;
		this.name = name;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
