package com.ashutosh.gameofcricket.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@AllArgsConstructor
@Document(collection="players")
public class Player {
    @MongoId
    private String id;
    private String name;
    private int age;
    private PlayerType type;
    private String country;
    private boolean isCoach;
}
