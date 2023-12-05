package com.ashutosh.gameofcricket.service;

import com.ashutosh.gameofcricket.model.*;
import com.ashutosh.gameofcricket.repository.PlayerRepository;
import com.ashutosh.gameofcricket.resource.StringMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.ashutosh.gameofcricket.utils.ScoreUtils.randomScoreGenerator;

@Service
public class MatchService {

    @Autowired
    static PlayerRepository playerRepository;

    @Autowired
    public MatchService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    public static Match createMatch(){
        List<Player> playersList = playerRepository.findAll();
        List<Player> firstTeamPlayerList = new ArrayList<>();
        List<Player> secondTeamPlayerList = new ArrayList<>();
        for (Player player : playersList) {
            if (player.getTeamId() == 1) {
                // Do something with the player
                firstTeamPlayerList.add(player);
            }
            if (player.getTeamId() == 2)
                secondTeamPlayerList.add(player);
        }
        /*  --Alternate approach: to use mongo query to make player list
        Query query = new Query();
        List<Player> playerList2 = playerRepository.findPlayersByTeamId(1);
        List<Player> firstTeamPlayerList = (List<Player>) query.addCriteria(Criteria.where("teamId").is(1));
        List<Player> secondTeamPlayerList = (List<Player>) query.addCriteria(Criteria.where("teamId").is(2));
         */
        Team teamA = new Team(1,"CSK",firstTeamPlayerList,null,"010");
        Team teamB = new Team(2,"MI",secondTeamPlayerList,null,"020");
        Innings firstInnings = new Innings(teamA,teamB,1,0);
        Innings secondeInnings = new Innings(teamB,teamA,2,0);
//        List<Player> playerList1 = new ArrayList<>();
//        playerList1.add(player1);
//        playerList1.add(player2);
//        List<Player> playerList2 = new ArrayList<>();
//        Player player3 = new Player("003", "Pandya", 30, PlayerType.ALLROUNDER, "India", false,2);
//        Player player4 = new Player("004", "Rohit",36, PlayerType.BATTER, "India", false,2);
//        playerList2.add(player3);
//        playerList2.add(player4);
        Match match = new Match(teamA,teamB,firstInnings,secondeInnings);
        return match;
    }


//    public static void main(String[] args) {
//        MatchService matchService = new MatchService();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter number of overs");
//        int overs = sc.nextInt();
//        int wickets = 0;
//        Match match = createMatch();
//        matchService.playMatch(overs,wickets,match);
//}


    public String playMatch(int overs, Match match){
        //first Innings to be played by first team
        List<ScoreInfo> firstInningsScoreInfoList = new ArrayList<>();
        List<ScoreInfo> secondInningsScoreInfoList = new ArrayList<>();
        firstInningsScoreInfoList = getInningsScore(overs);
        secondInningsScoreInfoList = getInningsScore(overs);
        int score1 = firstInningsScoreInfoList.get(firstInningsScoreInfoList.size()-1).getTotalRuns();
        int score2 = secondInningsScoreInfoList.get(firstInningsScoreInfoList.size()-1).getTotalRuns();
//        match.getHomeTeam().setScore(score1);
//        match.getTeam2().setScore(score2);
        String team1Name = match.getHomeTeam().getName();
        String team2Name = match.getAwayTeam().getName();
        String firstInningsResult = printTeamScore(match.getHomeTeam().getName(), score1);
        String secondInningsResult = printTeamScore(match.getAwayTeam().getName(), score2);
        String matchResult = printMatchResult(score1, score2,team1Name, team2Name);
        return firstInningsResult+"\n"+secondInningsResult+"\n"+matchResult;
    }

    private String printTeamScore(String teamName, int score) {
        String scoreSummary = "Team " + teamName + " scored: "+ score;
        System.out.println("Team " + teamName + " scored: "+ score);
        return scoreSummary;
    }

    private static String printMatchResult(int score1, int score2, String team1, String team2) {
        String matchResult;
        if(score1 > score2){
            matchResult = team1+" wins";
        }
        else if (score2 > score1) {
            matchResult = team2+" wins";
        }
        else
            matchResult = StringMessages.MATCH_DRAW_MESSAGE;
        System.out.println(matchResult);
        return matchResult;
    }

    private List<ScoreInfo> getInningsScore(int overs) {
        int wicketsFallen = 0;
        List<ScoreInfo> scoreInfoList = new ArrayList<>();
        int inningsScore = 0;
        boolean isOut = false;
        int ballNumber = 1;
        int overNumber = ballNumber/6;
        for(; ballNumber<=overs*6; ballNumber++){
            int runs = randomScoreGenerator();
            if(runs==StringMessages.WICKET_RUN){
                runs=0;
                wicketsFallen++;
                isOut = true;
            }
            inningsScore += runs;
            ScoreInfo scoreInfo = new ScoreInfo(null,null,runs,isOut,wicketsFallen,ballNumber,overNumber,inningsScore);
            scoreInfoList.add(scoreInfo);
            if(wicketsFallen== StringMessages.TOTAL_WICKETS){
                System.out.println(StringMessages.BOWLED_OUT_MESSAGE);
                break;
            }
        }
        return scoreInfoList;
    }
    private void loadPlayersAndTeams(){
    }

}
