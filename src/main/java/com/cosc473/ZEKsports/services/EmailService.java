package com.cosc473.ZEKsports.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosc473.ZEKsports.bo.Email;
import com.cosc473.ZEKsports.repositories.EmailRepository;
import com.cosc473.ZEKsports.utils.EmailSender;

@Service
public class EmailService {
	
	@Autowired
	private EmailRepository emailRepository;
	
	private String toAddress = null;
	private String subject = null;
	private String body = null;
	private EmailSender emailSender;
	private Email email;

	public void createEmail(Map<String, String> payload) throws Exception {
		
		emailSender = new EmailSender();
		toAddress = payload.get("toAddress");
		subject = payload.get("subject");
		body = payload.get("body");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String dateSent = dtf.format(LocalDateTime.now());

		try {
			email = new Email(toAddress, subject, body, dateSent);
			emailSender.sendEmail(email);
		} catch (Exception e) {
			throw new Exception("Unable to send email, bad request");
		}
		
		emailRepository.insert(email);
	}
}
