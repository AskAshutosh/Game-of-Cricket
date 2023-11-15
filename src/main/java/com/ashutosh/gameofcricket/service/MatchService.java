package com.ashutosh.gameofcricket.service;

import java.util.Random;

public class MatchService {

    public void playMatch(){
        //First Innings
        int score1=0;
        for(int i=0; i<6 ; i++){
            int run = randomScoreGenerator();
            if(run==7)
                run = 0;
            score1+=run;
        }

    }
    public int randomScoreGenerator(){
        Random random = new Random();
        int minRange = 0;
        int maxRange = 7;
        int randomScore = random.nextInt(maxRange-minRange+1)+minRange;
        return randomScore;
    }


    public static void main(String[] args) {
        MatchService m = new MatchService();
        for(int i=0; i<6; i++){
            int ans = m.randomScoreGenerator();
            System.out.println("Random score generated is : "+ans);
        }

    }
}
