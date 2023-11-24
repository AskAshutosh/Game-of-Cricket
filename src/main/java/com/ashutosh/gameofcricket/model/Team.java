package com.ashutosh.gameofcricket.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Team {
    private String id;
    private String name;
    private List<String> playerIds;
    //private List<Player> playersList;
    private List<Player> extras;
    private String coachId;

}

//Now make sure each player is defined as BatsMan or Bowler. Modify the random function to returns runs in
// high probability than wicket for the Batsman.