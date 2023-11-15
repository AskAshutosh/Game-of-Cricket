package com.ashutosh.gameofcricket.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Match {
    private Team team1;
    private Team team2;

    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
    }
}
