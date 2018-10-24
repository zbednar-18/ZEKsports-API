package com.cosc473.ZEKsports.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;  

import com.cosc473.ZEKsports.bo.NFLTeam;

@Repository
public interface NFLTeamRepository extends MongoRepository<NFLTeam, String> {

	public NFLTeam findByteamName(String teamName);
	public NFLTeam findByoverallTeamRank(int overallTeamRank);
}
