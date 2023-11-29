package com.ashutosh.gameofcricket.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Match {
    Team homeTeam;
    Team awayTeam;
    Innings firstInnings;
    Innings secondInnings;
    public Match(Team homeTeam, Team awayTeam, Innings firstInnings, Innings secondInnings) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.firstInnings = firstInnings;
        this.secondInnings = secondInnings;
    }
}
