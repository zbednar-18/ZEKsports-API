package com.cosc473.ZEKsports.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cosc473.ZEKsports.bo.NFLPlayer;
import com.cosc473.ZEKsports.repositories.NFLPlayerRepository;

@Service
public class NFLPlayerService {

	@Autowired
	private NFLPlayerRepository NFLPlayerRepository;

	public List<NFLPlayer> findAllNFLPlayers() {
		return NFLPlayerRepository.findAll();
	}

	public NFLPlayer findNFLPlayerByName(@PathVariable("firstName") String firstName,
			@PathVariable("lastName") String lastName) throws Exception {
		List<NFLPlayer> list = NFLPlayerRepository.findAll();
		for(NFLPlayer player : list) {
			if(player.getFirstName().equals(firstName) && player.getLastName().equals(lastName)) {
				return player;
			}
		}
		throw new Exception("Player not found");
	}

	public List<NFLPlayer> findNFLPlayerByPosition(@PathVariable("position") String position) throws Exception {
		List<NFLPlayer> list = NFLPlayerRepository.findByposition(position);
		if(list.isEmpty()) {
			throw new Exception("Position not found");
		}
		return list;
	}
}
