package com.ashutosh.gameofcricket.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Team {
    private int score;
    private List<Player> playersList;
}
