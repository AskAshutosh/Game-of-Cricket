package com.ashutosh.gameofcricket.repository;

import com.ashutosh.gameofcricket.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;


public interface PlayerRepository extends MongoRepository<Player,String> {
    @Query("{ 'teamId' : ?0 }")
    List<Player> findPlayersByTeamId(int teamId);
}
