package com.ashutosh.gameofcricket.service;

import com.ashutosh.gameofcricket.model.*;
import com.ashutosh.gameofcricket.repository.PlayerRepository;
import com.ashutosh.gameofcricket.resource.StringMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.ashutosh.gameofcricket.utils.ScoreUtils.randomScoreGenerator;

@Service
public class MatchService {

    @Autowired
    PlayerRepository playerRepository;
    public static Match createMatch(){
        Player player1 = new Player("001","MSD", 39, PlayerType.WICKETKEEPER,"India",false,1);
        Player player2 = new Player("002", "Jadeja", 33, PlayerType.ALLROUNDER, "India", false,1);
        List<Player> playerList1 = new ArrayList<>();
        playerList1.add(player1);
        playerList1.add(player2);
        List<Player> playerList2 = new ArrayList<>();
        Player player3 = new Player("003", "Pandya", 30, PlayerType.ALLROUNDER, "India", false,2);
        Player player4 = new Player("004", "Rohit",36, PlayerType.BATTER, "India", false,2);
        playerList2.add(player3);
        playerList2.add(player4);
        Team teamA = new Team(1,"CSK",playerList1,null,"010");
        Team teamB = new Team(2,"MI",playerList2,null,"020");
        Innings firstInnings = new Innings(teamA,teamB,1,0);
        Innings secondeInnings = new Innings(teamB,teamA,2,0);
        Match match = new Match(teamA,teamB,firstInnings,secondeInnings);
        return match;
    }

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }


    public static void main(String[] args) {
        MatchService matchService = new MatchService();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of overs");
        int overs = sc.nextInt();
        int wickets = 0;
        Match match = createMatch();
        matchService.playMatch(overs,wickets,match);
    }

    public void playMatch(int overs, int wickets, Match match){
        //first Innings to be played by first team
        List<ScoreInfo> firstInningsScoreInfoList = new ArrayList<>();
        List<ScoreInfo> secondInningsScoreInfoList = new ArrayList<>();
        firstInningsScoreInfoList = getInningsScore(overs,wickets);
        secondInningsScoreInfoList = getInningsScore(overs,wickets);
        int score1 = firstInningsScoreInfoList.get(firstInningsScoreInfoList.size()-1).getTotalRuns();
        int score2 = secondInningsScoreInfoList.get(firstInningsScoreInfoList.size()-1).getTotalRuns();
//        match.getTeam1().setScore(score1);
//        match.getTeam2().setScore(score2);
        String team1Name = match.getHomeTeam().getName();
        String team2Name = match.getAwayTeam().getName();
        printTeamScore(match.getHomeTeam().getName(), score1);
        printTeamScore(match.getAwayTeam().getName(), score2);
        printMatchResult(score1, score2,team1Name, team2Name);

    }

    private static void printTeamScore(String teamName, int score) {
        System.out.println("Team " + teamName + " scored: "+ score);
    }

    private static void printMatchResult(int score1, int score2,String team1, String team2) {
        if(score1 > score2)
            System.out.println("Team "+team1+" wins");
        else if (score2 > score1) {
            System.out.println("Team "+team2+" wins");
        }
        else
            System.out.println(StringMessages.MATCH_DRAW_MESSAGE);
    }

    private List<ScoreInfo> getInningsScore(int overs,int wickets) {
        List<ScoreInfo> scoreInfoList = new ArrayList<>();
        int inningsScore = 0;
        boolean isOut = false;
        int ballNumber = 1;
        int overNumber = ballNumber/6;
        for(; ballNumber<=overs*6; ballNumber++){
            int runs = randomScoreGenerator();
            if(runs==StringMessages.WICKET_RUN){
                runs=0;
                wickets++;
                isOut = true;
            }
            inningsScore += runs;
            if(wickets== StringMessages.TOTAL_WICKETS){
                System.out.println(StringMessages.BOWLED_OUT_MESSAGE);
                break;
            }
            ScoreInfo scoreInfo = new ScoreInfo(null,null,runs,isOut,wickets,ballNumber,overNumber,inningsScore);
            scoreInfoList.add(scoreInfo);
        }
        return scoreInfoList;
    }
}
