package com.cosc473.ZEKsports.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cosc473.ZEKsports.bo.NFLPlayer;
import com.cosc473.ZEKsports.bo.NFLTeam;
import com.cosc473.ZEKsports.repositories.NFLPlayerRepository;
import com.cosc473.ZEKsports.repositories.NFLTeamRepository;

@Service
public class NFLTeamService {

	@Autowired
	private NFLTeamRepository NFLTeamRepository;

	@Autowired
	private NFLPlayerRepository NFLPlayerRepository;

	public List<NFLTeam> getAllTeams() {
		return NFLTeamRepository.findAll();
	}
	
	public NFLTeam findNFLTeamByName(@PathVariable("teamName") String teamName) throws Exception{
		NFLTeam team = NFLTeamRepository.findByteamName(teamName);
		if(team == null) {
			throw new Exception("Team not found");
		}
		return team;
	}
	
	public List<NFLPlayer> findNFLPlayersByTeam(@PathVariable("team") String team) throws Exception {
		List<NFLPlayer> list = NFLPlayerRepository.findByteam(team);
		if(list.isEmpty()) {
			throw new Exception("Team not found");
		}
		return list;
	}
	
	public NFLTeam findNFLTeamByRank(@PathVariable("overallTeamRank") int overallTeamRank) throws Exception {
		if(overallTeamRank > 32) {
			throw new Exception("Rank entered > 32");
		}
		return NFLTeamRepository.findByoverallTeamRank(overallTeamRank);
	}
}
