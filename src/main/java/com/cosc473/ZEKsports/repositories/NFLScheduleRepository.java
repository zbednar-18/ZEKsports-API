package com.cosc473.ZEKsports.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cosc473.ZEKsports.bo.NFLSchedule;

@Repository
public interface NFLScheduleRepository extends MongoRepository<NFLSchedule, String> {

	public List<NFLSchedule> findBydate(String date);

	public List<NFLSchedule> findByweek(String week);

	public List<NFLSchedule> findByhometeam(String hometeam);

	public List<NFLSchedule> findByawayteam(String awayteam);
}
