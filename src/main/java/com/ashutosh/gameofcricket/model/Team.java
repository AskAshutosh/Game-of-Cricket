package com.ashutosh.gameofcricket.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Team {
    private String id;
    private String name;
    private List<Player> playerList;
    //private List<Player> playersList;
    private List<Player> extrasList;
    private String coachId;

}

//Now make sure each player is defined as BatsMan or Bowler. Modify the random function to returns runs in
// high probability than wicket for the Batsman.