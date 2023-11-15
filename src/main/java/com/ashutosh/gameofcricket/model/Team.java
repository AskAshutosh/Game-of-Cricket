package com.ashutosh.gameofcricket.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Team {
    private List<Player> playersList;
}
