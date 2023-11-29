package com.ashutosh.gameofcricket.controller;

import com.ashutosh.gameofcricket.model.Player;

import com.ashutosh.gameofcricket.repository.ItemRepository;
import com.ashutosh.gameofcricket.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MatchController {

    MatchService matchService;
    @Autowired
    ItemRepository itemRepository;
    @GetMapping("/players")
    public List<Player> getAllPlayers(){
        return itemRepository.findAll();
    }

    @GetMapping("/players/{id}")
    public Optional<Player> findPlayersById(@PathVariable String id){
        return itemRepository.findById(id);
    }

    @GetMapping("/players/startmatch")
    public void play(){

    }
}
