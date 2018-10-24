package com.cosc473.ZEKsports.controllers;

import com.cosc473.ZEKsports.services.NFLTeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/nfl")
public class NFLTeamController {

	@Autowired
	private NFLTeamService nflTeamService;

	@RequestMapping(value = "/teams", method = RequestMethod.GET)
	public ResponseEntity<?> getAllTeams() {
		return ResponseEntity.status(HttpStatus.OK).body(nflTeamService.getAllTeams());
	}

	@RequestMapping(value = "/teams/{teamName}")
	public ResponseEntity<?> findNFLTeamByName(@PathVariable("teamName") String teamName) {
		try {
			return ResponseEntity.ok(nflTeamService.findNFLTeamByName(teamName));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@RequestMapping(value = "/teams/{team}/players", method = RequestMethod.GET)
	public ResponseEntity<?> findNFLPlayersByTeam(@PathVariable("team") String team) {
		try {
			return ResponseEntity.ok(nflTeamService.findNFLPlayersByTeam(team));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@RequestMapping(value = "/teams/ranks/{overallTeamRank}", method = RequestMethod.GET)
	public ResponseEntity<?> findNFLTeamByRank(@PathVariable("overallTeamRank") int overallTeamRank) {
		try {
			return ResponseEntity.ok(nflTeamService.findNFLTeamByRank(overallTeamRank));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@RequestMapping(value = "/teams/conference/{conference}/division/{division}", method = RequestMethod.GET)
	public ResponseEntity<?> findNFLTeamByDivision(@PathVariable("conference") String conference,
			@PathVariable("division") String division) {
		try {
			return ResponseEntity.ok(nflTeamService.findNFLTeamByDivision(conference, division));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
