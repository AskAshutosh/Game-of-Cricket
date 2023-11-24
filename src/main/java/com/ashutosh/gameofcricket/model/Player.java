package com.ashutosh.gameofcricket.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String id;
    private String name;
    private int age;
    private PlayerType type;
    private String country;
    private boolean isCoach;
}
