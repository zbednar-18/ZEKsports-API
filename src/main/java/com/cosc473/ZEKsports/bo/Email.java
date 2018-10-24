package com.cosc473.ZEKsports.bo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Email")
public class Email {

	private String toAddress;
	private String subject;
	private String body;
	private String dateSent;

	public Email() {
	}

	public Email(String toAddresses, String subject, String body, String dateSent) {
		this.toAddress = toAddresses;
		this.subject = subject;
		this.body = body;
		this.dateSent = dateSent;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDateSent() {
		return dateSent;
	}

	public void setDateSent(String dateSent) {
		this.dateSent = dateSent;
	}

}
