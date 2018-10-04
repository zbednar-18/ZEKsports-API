package com.cosc473.ZEKsports.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cosc473.ZEKsports.bo.NFLPlayer;
import com.cosc473.ZEKsports.bo.NFLTeam;

@Repository
public interface NFLPlayerRepository extends MongoRepository<NFLPlayer, String> {

	public List<NFLPlayer> findByfirstName(String firstName);

	public List<NFLPlayer> findByteam(String team);

	public List<NFLPlayer> findByposition(String position);
}
