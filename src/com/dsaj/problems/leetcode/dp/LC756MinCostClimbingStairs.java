package com.dsaj.problems.leetcode.dp;

import java.util.Arrays;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC756MinCostClimbingStairsSolution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length < 3) {
            return Arrays.stream(cost).min().getAsInt();
        }

        int[] minCosts = new int[cost.length];
        minCosts[0] = cost[0];
        minCosts[1] = cost[1];


        for (int i = 2; i < cost.length; i++) {
            minCosts[i] = cost[i] + Math.min(minCosts[i-1], minCosts[i-2]);
        }

        return Math.min(minCosts[cost.length-1], minCosts[cost.length-2]);
    }
}

class LC756MinCostClimbingStairsEfficientSolution {
    public int minCostClimbingStairs(int[] cost) {
        int min1 = cost[0];
        int min2 = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int min;
            if (min2 <= min1) {
                min = min2 + cost[i];
            } else {
                min = min1+cost[i];
            }
            min1 = min2;
            min2 = min;
        }

        return Math.min(min1, min2);
    }
}

public class LC756MinCostClimbingStairs {
    public static void main(String[] args) {
        LC756MinCostClimbingStairsSolution solution = new LC756MinCostClimbingStairsSolution();

        int[] cost = SystemUtils.takeIntArrayInput("Enter cost values: ");

        System.out.println("Min cost: " + solution.minCostClimbingStairs(cost));
    }
}
