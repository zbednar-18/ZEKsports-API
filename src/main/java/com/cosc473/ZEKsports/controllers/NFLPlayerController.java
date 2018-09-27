package com.cosc473.ZEKsports.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cosc473.ZEKsports.bo.NFLPlayer;
import com.cosc473.ZEKsports.repositories.NFLPlayerRepository;

@RestController
@CrossOrigin
@RequestMapping(value = "/nfl")
public class NFLPlayerController {

	@Autowired
	private NFLPlayerRepository NFLPlayerRepository;

	@RequestMapping(value = "/players", method = RequestMethod.GET)
	public List<NFLPlayer> findAllNFLPlayers() {
		return NFLPlayerRepository.findAll();
	}

	@RequestMapping(value = "/players/firstName/{firstName}/lastName/{lastName}", method = RequestMethod.GET)
	public NFLPlayer findNFLPlayerByName(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		return null;
	}

	@RequestMapping(value = "/players/teams/{team}")
	public List<NFLPlayer> findNFLPlayersByTeam(@PathVariable("team") String team) {
		return NFLPlayerRepository.findByteam(team);
	}

	@RequestMapping(value = "/players/positions/{position}")
	public List<NFLPlayer> findNFLPlayerByPosition(@PathVariable("position") String position) {
		return NFLPlayerRepository.findByposition(position);
	}
}
