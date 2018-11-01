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

	public Email createEmail(Map<String, String> payload) throws Exception {
		String toAddress = payload.get("toAddress");
		String subject = payload.get("subject");
		String body = payload.get("body");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String dateSent = dtf.format(LocalDateTime.now());
		return new Email(toAddress, subject, body, dateSent);

	}

	public void sendEmail(Email userEmail) throws Exception {
		EmailSender emailSender = new EmailSender();
		try {
			emailSender.sendEmail(userEmail);
		} catch (Exception e) {
			throw new Exception("Unable to send email: " + e.getMessage());
		}
		emailRepository.insert(userEmail);
	}
}
