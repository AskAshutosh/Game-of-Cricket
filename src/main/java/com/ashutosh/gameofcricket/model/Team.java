package com.ashutosh.gameofcricket.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "teams")
public class Team {
    @MongoId
    private int id;
    private String name;
    //private List<Integer> playerIdList;
    private List<Player> playersList;
    //private List<Player> extrasIdList;
    private List<Player> extrasList;
    private String coachId;

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", playerIdList=" + playersList +
                ", extrasIdList=" + extrasList +
                ", coachId='" + coachId + '\'' +
                '}';
    }
}

//Now make sure each player is defined as BatsMan or Bowler. Modify the random function to returns runs in
// high probability than wicket for the Batsman.