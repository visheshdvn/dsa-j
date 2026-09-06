package com.dsaj.problems.leetcode.binarysearch;

import java.util.Arrays;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC875KokoEatingBananasSolution {
    private int eatingTime(int[] piles, int speed) {
        int totalTime = 0;

        for (int pile : piles) {
            totalTime += Math.ceil((double) pile / speed);
        }

        return totalTime;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int min = 0;
        int max = Arrays.stream(piles).max().getAsInt();

        while (min < max) {
            int mid = min + (max - min) / 2;

            if(eatingTime(piles, mid) <= h) {
                max = mid;
            } else {
                min = mid+1;
            }
        }

        return min;
    }
}

public class LC875KokoEatingBananas {
    public static void main(String[] args) {
        LC875KokoEatingBananasSolution solution = new LC875KokoEatingBananasSolution();

        int[] piles = SystemUtils.takeIntArrayInput("Enter piles: ");
        int h = SystemUtils.takeIntInput("Enter hours: ");

        int result = solution.minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + result);
    }
}
