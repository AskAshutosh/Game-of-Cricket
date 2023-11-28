package com.ashutosh.gameofcricket.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Innings {
    //private List<Overs> overs;
    private Team fieldingTeam;
    private Team battingTeam;
    private int inningsNumber;
    private int finalScore;
}
