package com.ashutosh.gameofcricket.controller;

import com.ashutosh.gameofcricket.model.Match;

import static com.ashutosh.gameofcricket.utils.ScoreUtils.randomScoreGenerator;

public class MatchController {
    public static final int TOTAL_BALLS_IN_OVER = 6;
    public static final int WICKET_RUN = 7;
    public static final String MATCH_DRWA_MESSAGE = "It's a draw";
    private final String team1 = "";

    Match match; private final String team1 = "";

    public static void main(String[] args) {
        MatchController matchController = new MatchController();
        matchController.playMatch();
    }

    private void playMatch(){
        //first Innings to be played by first team
        int score1 = getInningsScore();
        int score2 = getInningsScore();
        match.getTeam1().setScore(score1);
        match.getTeam2().setScore(score2);
        printTeamScore("team1", score1);
        printTeamScore("team2", score2);
        printMatchResult(score1, score2);
    }

    private static void printTeamScore(String teamName, int score) {
        System.out.println("Team " + teamName + " scored: "+ score);
    }

    private static void printMatchResult(int score1, int score2) {
        if(score1 > score2)
            System.out.println("Team A wins");
        else if (score2 > score1) {
            System.out.println("Team B wins");
        }
        else
            System.out.println(MATCH_DRWA_MESSAGE);
    }

    private int getInningsScore() {
        int score = 0;
        for (int ballNumber = 0; ballNumber < TOTAL_BALLS_IN_OVER; ballNumber++) {
            int runs = randomScoreGenerator();
            if (runs == WICKET_RUN)
                runs = 0;
            score += runs;
        }
        return score;
    }
}
