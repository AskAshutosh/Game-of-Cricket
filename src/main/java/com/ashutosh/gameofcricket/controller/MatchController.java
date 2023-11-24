package com.ashutosh.gameofcricket.controller;

import java.util.Scanner;

import static com.ashutosh.gameofcricket.utils.ScoreUtils.randomScoreGenerator;

public class MatchController {
    public static final int TOTAL_BALLS_IN_OVER = 6;
    public static final int WICKET_RUN = 7;
    public static final String MATCH_DRAW_MESSAGE = "It's a draw";
    private final String team1 = "";

    public static void main(String[] args) {
        MatchController matchController = new MatchController();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of overs");
        int overs = sc.nextInt();
        matchController.playMatch(overs);
    }

    private void playMatch(int overs){
        //first Innings to be played by first team
        int score1 = getInningsScore(overs);
        int score2 = getInningsScore(overs);
//        match.getTeam1().setScore(score1);
//        match.getTeam2().setScore(score2);
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
            System.out.println(MATCH_DRAW_MESSAGE);
    }

    private int getInningsScore(int overs) {
        int score = 0;
        for (int ballNumber = 0; ballNumber < TOTAL_BALLS_IN_OVER*overs; ballNumber++) {
            int runs = randomScoreGenerator();
            if (runs == WICKET_RUN)
                runs = 0;
            score += runs;
        }
        return score;
    }

}
