package com.ashutosh.gameofcricket.repository;

import com.ashutosh.gameofcricket.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ItemRepository extends MongoRepository<Player,String> {

}
