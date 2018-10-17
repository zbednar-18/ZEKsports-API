package com.cosc473.ZEKsports.controllers;

import com.cosc473.ZEKsports.repositories.NFLTeamRepository;
import com.cosc473.ZEKsports.repositories.NFLPlayerRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cosc473.ZEKsports.bo.NFLPlayer;
import com.cosc473.ZEKsports.bo.NFLTeam;

@CrossOrigin
@RestController
@RequestMapping("/nfl")
public class NFLTeamController {

	@Autowired
	private NFLTeamRepository NFLTeamRepository;

	@Autowired
	private NFLPlayerRepository NFLPlayerRepository;

	@RequestMapping(value = "/teams", method = RequestMethod.GET)
	public List<NFLTeam> getAllTeams() {
		return NFLTeamRepository.findAll();
	}
	
	@RequestMapping(value = "/teams/{teamName}")
	public List<NFLTeam> findNFLTeamByName(@PathVariable("teamName") String teamName){
		return NFLTeamRepository.findByteamName(teamName);
	}

	@RequestMapping(value = "/teams/{team}/players", method = RequestMethod.GET)
	public List<NFLPlayer> findNFLPlayersByTeam(@PathVariable("team") String team) {
		return NFLPlayerRepository.findByteam(team);
	}

	@RequestMapping(value = "/teams/ranks/{overallTeamRank}", method = RequestMethod.GET)
	public List<NFLTeam> findNFLTeamByRank(@PathVariable("overallTeamRank") int overallTeamRank) {
		return NFLTeamRepository.findByoverallTeamRank(overallTeamRank);
	}
}
