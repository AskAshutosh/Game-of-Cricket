package com.ashutosh.gameofcricket.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Scoreboard {
    private List<Over> overs;
}
//ScoreBoard should be printed after every match (should contain overs done, Batting team, batsman,
// run on curr ball, total runs). Feel free to enhance more also