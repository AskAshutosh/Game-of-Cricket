package com.ashutosh.gameofcricket.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScoreInfo {
    private Innings innings;
    private String batsmanId;
    private  String bowlerId;
    private int runsScored;
    private boolean isOut;
    private int totalRuns;
    private int totalWickets;
    private int ballNumber;
    private int overNumber;
}
