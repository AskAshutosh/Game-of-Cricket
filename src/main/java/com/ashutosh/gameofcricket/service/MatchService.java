package com.ashutosh.gameofcricket.service;

import java.util.Random;

public class MatchService {
    public int randomScoreGenerator(){
        Random random = new Random();
        int minRange = 0;
        int maxRange = 7;
        int randomScore = random.nextInt(maxRange-minRange+1)+minRange;
        return randomScore;
    }

    public static void main(String[] args) {
        MatchService m = new MatchService();
        for(int i=0; i<10; i++){
            int ans = m.randomScoreGenerator();
            System.out.println("Random score generated is : "+ans);
        }

    }
}
