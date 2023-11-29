package com.ashutosh.gameofcricket.repository;

import com.ashutosh.gameofcricket.model.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepository extends MongoRepository<Team, Integer> {

}
