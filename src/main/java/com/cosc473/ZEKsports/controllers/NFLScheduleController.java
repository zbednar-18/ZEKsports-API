package com.cosc473.ZEKsports.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cosc473.ZEKsports.services.NFLScheduleService;

@RestController
@CrossOrigin
@RequestMapping(value = "/nfl")
public class NFLScheduleController {

	@Autowired
	private NFLScheduleService NFLScheduleService;

	@RequestMapping(value = "/schedules", method = RequestMethod.GET)
	public ResponseEntity<?> findAllGames() {
		return ResponseEntity.ok(NFLScheduleService.findAllGames());
	}

	@RequestMapping(value = "/schedules/weeks/{week}", method = RequestMethod.GET)
	public ResponseEntity<?> findGamesByWeek(@PathVariable("week") String week) {
		try {
			return ResponseEntity.ok(NFLScheduleService.findGamesByWeek(week));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@RequestMapping(value = "/schedules/weeks/current", method = RequestMethod.GET)
	public String findCurrentWeek() {
		return NFLScheduleService.getCurrentWeek();
	}

	@RequestMapping(value = "/schedules/dates/{date}", method = RequestMethod.GET)
	public ResponseEntity<?> findGamesByDate(@PathVariable("date") String date) {
		try {
			return ResponseEntity.ok(NFLScheduleService.findGamesByDate(date));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@RequestMapping(value = "/schedules/teams/{team}", method = RequestMethod.GET)
	public ResponseEntity<?> findGamesByTeam(@PathVariable("team") String team) {
		try {
			return ResponseEntity.ok(NFLScheduleService.findGamesByTeam(team));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
