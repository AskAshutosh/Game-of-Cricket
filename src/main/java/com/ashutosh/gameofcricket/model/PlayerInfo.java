package com.ashutosh.gameofcricket.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlayerInfo {
    private String playerId;
    private int totalRunsScored;
    private int totalWicketsTaken;
}
