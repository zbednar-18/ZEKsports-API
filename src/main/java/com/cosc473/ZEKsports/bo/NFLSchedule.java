package com.cosc473.ZEKsports.bo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "NFLSchedule")
public class NFLSchedule {

	private String week;
	private String date;
	private String time;
	private String hometeam;
	private String awayteam;
	private String stadium;
	
	public NFLSchedule() {}

	public NFLSchedule(String week, String date, String time, String hometeam, String awayteam, String stadium) {
		this.week = week;
		this.date = date;
		this.time = time;
		this.hometeam = hometeam;
		this.awayteam = awayteam;
		this.stadium = stadium;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getHometeam() {
		return hometeam;
	}

	public void setHometeam(String hometeam) {
		this.hometeam = hometeam;
	}

	public String getAwayteam() {
		return awayteam;
	}

	public void setAwayteam(String awayteam) {
		this.awayteam = awayteam;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
}
