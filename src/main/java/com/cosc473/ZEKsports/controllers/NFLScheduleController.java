package com.cosc473.ZEKsports.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cosc473.ZEKsports.bo.NFLSchedule;
import com.cosc473.ZEKsports.repositories.NFLScheduleRepository;

@RestController
@CrossOrigin
@RequestMapping(value = "/nfl")
public class NFLScheduleController {

	@Autowired
	private NFLScheduleRepository NFLScheduleRepository;

	@RequestMapping(value = "/schedules", method = RequestMethod.GET)
	public List<NFLSchedule> findAllGames() {
		return NFLScheduleRepository.findAll();
	}

	@RequestMapping(value = "/schedules/weeks/{week}", method = RequestMethod.GET)
	public List<NFLSchedule> findGamesByWeek(@PathVariable("week") String week) {
		return NFLScheduleRepository.findByweek(week);
	}

	@RequestMapping(value = "/schedules/dates/{date}", method = RequestMethod.GET)
	public List<NFLSchedule> findGamesByDate(@PathVariable("date") String date) {
		return NFLScheduleRepository.findBydate(date);
	}

	@RequestMapping(value = "/schedules/teams/{team}", method = RequestMethod.GET)
	public List<NFLSchedule> findGamesByTeam(@PathVariable("team") String team) {
		List<NFLSchedule> awayTeams = NFLScheduleRepository.findByawayteam(team);
		List<NFLSchedule> homeTeams = NFLScheduleRepository.findByhometeam(team);
		homeTeams.addAll(awayTeams);
		return homeTeams;
	}

}