package com.ashutosh.gameofcricket.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Innings {
    private Team fieldingTeam;
    private Team battingTeam;
    private int inningsNumber;
}
