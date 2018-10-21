package com.cosc473.ZEKsports.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cosc473.ZEKsports.bo.Bug;

@Repository
public interface BugRepository extends MongoRepository<Bug, String> {

	public List<Bug> findBydateReported();
	public List<Bug> findBybugReporter();
}
