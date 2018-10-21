package com.cosc473.ZEKsports.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosc473.ZEKsports.bo.Bug;
import com.cosc473.ZEKsports.repositories.BugRepository;

@Service
public class BugService {

	@Autowired
	private BugRepository bugRepository;
	
	public String createBug(Map<String, String> payload) {
		String bugReporter = payload.get("bugReporter");
		String description = payload.get("description");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");   
		String dateReported = dtf.format(LocalDateTime.now());
		
		if(bugReporter.equals("") || description.equals("")){
			return "";
		}
		bugRepository.insert(new Bug(bugReporter, description, dateReported));
		return "created";
	}
}
