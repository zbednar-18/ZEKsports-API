package com.cosc473.ZEKsports.bo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "NFLPlayer")
public class NFLPlayer {

	private String firstName;
	private String lastName;
	private String jerseyNumber;
	private String position;
	private String height;
	private String weight;
	private String dateOfBirth;
	private String isRookie;
	private String team;

	public NFLPlayer(String firstName, String lastName, String jerseyNumber, String position, String height,
			String weight, String dateOfBirth, String isRookie, String team) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.jerseyNumber = jerseyNumber;
		this.position = position;
		this.height = height;
		this.weight = weight;
		this.dateOfBirth = dateOfBirth;
		this.isRookie = isRookie;
		this.team = team;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJerseyNumber() {
		return jerseyNumber;
	}

	public void setJerseyNumber(String jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getIsRookie() {
		return isRookie;
	}

	public void setIsRookie(String isRookie) {
		this.isRookie = isRookie;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

}
