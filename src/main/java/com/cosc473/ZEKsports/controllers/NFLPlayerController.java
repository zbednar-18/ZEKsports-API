package com.cosc473.ZEKsports.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cosc473.ZEKsports.bo.NFLPlayer;
import com.cosc473.ZEKsports.services.NFLPlayerService;

@RestController
@CrossOrigin
@RequestMapping(value = "/nfl")
public class NFLPlayerController {

	@Autowired
	private NFLPlayerService nflPlayerService;

	@RequestMapping(value = "/players", method = RequestMethod.GET)
	public List<NFLPlayer> findAllNFLPlayers() {
		return nflPlayerService.findAllNFLPlayers();
	}

	@RequestMapping(value = "/players/firstName/{firstName}/lastName/{lastName}", method = RequestMethod.GET)
	public ResponseEntity<?> findNFLPlayerByName(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(nflPlayerService.findNFLPlayerByName(firstName, lastName));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@RequestMapping(value = "/players/positions/{position}")
	public ResponseEntity<?> findNFLPlayerByPosition(@PathVariable("position") String position) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(nflPlayerService.findNFLPlayerByPosition(position.toUpperCase()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
}
