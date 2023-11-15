package com.ashutosh.gameofcricket.controller;

import com.ashutosh.gameofcricket.model.Match;

import java.util.Random;

public class MatchController {
    Match match;
    public void playMatch(){
        //first Innings to be played by first team
        int score1 = 0;
        for(int i=0; i<6; i++){
            int runs = randomScoreGenerator();
            if(runs == 7)
                runs = 0;
            score1 += runs;
        }
        int score2=0;
        for(int i=0; i<6; i++){
            int runs = randomScoreGenerator();
            if(runs == 7)
                runs = 0;
            score2 += runs;
        }
        match.getTeam1().setScore(score1);
        match.getTeam2().setScore(score2);
        System.out.println("Team A scored: "+score1);
        System.out.println("Team B scored: "+score2);
        if(score1 > score2)
            System.out.println("Team A wins");
        else if (score2 > score1) {
            System.out.println("Team B wins");
        }
        else
            System.out.println("It's a draw");
    }
    public int randomScoreGenerator(){
        Random random = new Random();
        int minRange = 0;
        int maxRange = 7;
        int randomScore = random.nextInt(maxRange-minRange+1)+minRange;
        return randomScore;
    }

    public static void main(String[] args) {
        MatchController matchController = new MatchController();
        matchController.playMatch();
    }
}
