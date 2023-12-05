package com.ashutosh.gameofcricket.controller;

import com.ashutosh.gameofcricket.model.Match;
import com.ashutosh.gameofcricket.model.Player;

import com.ashutosh.gameofcricket.model.Team;
import com.ashutosh.gameofcricket.repository.PlayerRepository;
import com.ashutosh.gameofcricket.repository.TeamRepository;
import com.ashutosh.gameofcricket.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MatchController {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    MatchService matchService;
    @PostMapping("/playmatch/{overs}")
    public ResponseEntity playMatch(@PathVariable Integer overs){
        Match match = matchService.createMatch();
        String response = matchService.playMatch(overs, match);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/getallplayers")
    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    @GetMapping("/players/{id}")
    public Optional<Player> findPlayersById(@PathVariable String id){
        return playerRepository.findById(id);
    }

    @GetMapping("/getallteams")
    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    @GetMapping("/teams/{id}")
    public Optional<Team> getTeamById(@PathVariable Integer id){
        return teamRepository.findById(id);
    }

    @PostMapping("/addplayer")
    public Player addPlayer(@RequestBody Player player){
        return playerRepository.save(player);
    }

    @PostMapping("/teams")
    public Team addTeam(@RequestBody Team team){
        return teamRepository.save(team);
    }
}
