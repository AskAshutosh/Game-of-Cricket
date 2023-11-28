package com.ashutosh.gameofcricket.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScoreInfo {
//    private Innings innings;
    private List<String> batsmanIds;
    private List<String> bowlerId;
    private int runsScored;
    private boolean isOut;
    private int totalWickets;
    private int ballNumber;
    private int overNumber;
    private int totalRuns;
}
