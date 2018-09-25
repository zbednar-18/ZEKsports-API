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
	
	@RequestMapping(value = "/player", method = RequestMethod.GET)
	public List<NFLPlayer> findAllNFLPlayers() {
		return NFLPlayerRepository.findAll();
	}
	
	@RequestMapping(value = "/player/{firstName}", method = RequestMethod.GET)
	public void findNFLPlayerByFirstName(@PathVariable("firstName") String firstName) {
	}
	
	@RequestMapping (value = "/player/team/{team}")
	public List<NFLPlayer> findNFLPlayersByTeam(@PathVariable("team") String team){
		return NFLPlayerRepository.findByteam(team);
	}
	
	@RequestMapping(value = "/player/position/{position}")
	public List<NFLPlayer> findNFLPlayerByPosition(@PathVariable("position") String position){
		return NFLPlayerRepository.findByposition(position);
	}
}
