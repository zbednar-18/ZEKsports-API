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
@RequestMapping(value = "/NFL")
public class NFLScheduleController {

	@Autowired
	private NFLScheduleRepository NFLScheduleRepository;
	
	@RequestMapping(value = "/schedule", method = RequestMethod.GET)
	public List<NFLSchedule> findAllGames() {
		return NFLScheduleRepository.findAll();
	}
	
	@RequestMapping(value = "/schedule/date/{date}")
	public List<NFLSchedule> findGamesByDate(@PathVariable("date") String date){
		return NFLScheduleRepository.findBydate(date);
	}
	
	@RequestMapping(value = "/schedule/team/{team}")
	public List<NFLSchedule> findGamesByTeam(@PathVariable("team") String team){
		List<NFLSchedule> awayTeams = NFLScheduleRepository.findByawayteam(team);
		List<NFLSchedule> homeTeams = NFLScheduleRepository.findByhometeam(team);
		homeTeams.addAll(awayTeams);
		return homeTeams;
	}
	
	@RequestMapping(value = "/schedule/week/{week}")
	public List<NFLSchedule> findGamesByWeek(@PathVariable("week") String week){
		return NFLScheduleRepository.findByweek(week);
	}
}
