package com.cosc473.ZEKsports.bo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Bug")
public class Bug {

	private String bugReporter;
	private String description;
	private String dateReported;

	public Bug() {
	}

	public Bug(String bugReporter, String description, String dateReported) {
		this.bugReporter = bugReporter;
		this.description = description;
		this.dateReported = dateReported;
	}

	public String getBugReporter() {
		return bugReporter;
	}

	public void setBugReporter(String bugReporter) {
		this.bugReporter = bugReporter;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateReported() {
		return dateReported;
	}

	public void setDateReported(String dateReported) {
		this.dateReported = dateReported;
	}

}
