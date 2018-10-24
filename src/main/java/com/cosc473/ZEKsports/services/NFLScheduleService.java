package com.cosc473.ZEKsports.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosc473.ZEKsports.bo.NFLSchedule;
import com.cosc473.ZEKsports.bo.NFLTeam;
import com.cosc473.ZEKsports.repositories.NFLScheduleRepository;
import com.cosc473.ZEKsports.repositories.NFLTeamRepository;

@Service
public class NFLScheduleService {

	@Autowired
	private NFLScheduleRepository NFLScheduleRepository;
	@Autowired
	private NFLTeamRepository NFLTeamRepository;

	public List<NFLSchedule> findAllGames() {
		return NFLScheduleRepository.findAll();
	}

	public List<NFLSchedule> findGamesByWeek(String week) throws Exception {
		if (Integer.parseInt(week) > 17) {
			throw new Exception("Week entered is greater than 17");
		}
		return NFLScheduleRepository.findByweek(week);
	}

	public String getCurrentWeek() {
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		List<NFLSchedule> list = NFLScheduleRepository.findBydate(ft.format(date));
		Calendar c;
		while (list.isEmpty()) {
			c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DATE, 1);
			date = c.getTime();
			list = NFLScheduleRepository.findBydate(ft.format(date));
		}
		return list.get(0).getWeek();
	}

	public List<NFLSchedule> findGamesByDate(String date) throws Exception {
		List<NFLSchedule> scheduleList = NFLScheduleRepository.findBydate(date);
		if (scheduleList.isEmpty()) {
			throw new Exception("No games found for this date");
		}
		return scheduleList;
	}

	public List<NFLSchedule> findGamesByTeam(String team) throws Exception {
		List<NFLTeam> teams = NFLTeamRepository.findAll();
		for (NFLTeam currentTeam : teams) {
			if (currentTeam.getTeamName().equals(team)) {
				System.out.println("entered if");
				List<NFLSchedule> awayTeams = NFLScheduleRepository.findByawayteam(team);
				List<NFLSchedule> homeTeams = NFLScheduleRepository.findByhometeam(team);
				homeTeams.addAll(awayTeams);
				return homeTeams;
			}
		}
		throw new Exception("Team name does not exist");
	}
}
