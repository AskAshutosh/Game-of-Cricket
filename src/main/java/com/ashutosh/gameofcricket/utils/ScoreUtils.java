package com.ashutosh.gameofcricket.utils;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class ScoreUtils {
    public static int randomScoreGenerator(){
        Random random = new Random();
        int minRange = 0;
        int maxRange = 7;
        return random.nextInt(maxRange-minRange+1)+minRange;
    }

}
