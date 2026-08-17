package com.dsaj.problems.leetcode.stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        // if there is only 1 car return 1
        if (position.length == 1)
            return 1;

        // keep track of all car fleets
        Stack<Double> stack = new Stack<>();

        // 1st [] represent position
        // 2nd [] represent speed
        int[][] combine = new int[position.length][2];
        for (int i = 0; i < combine.length; i++) {
            combine[i] = new int[] { position[i], speed[i] };
        }

        // sort the combine array in asc order, on the basis of position
        // so we can see the actual position of all the cars on the road
        Arrays.sort(combine, Comparator.comparingInt(o -> o[0]));

        for (int i = combine.length - 1; i >= 0; i--) {
            double currentTime = (double) (target - combine[i][0]) / combine[i][1];

            // find currentTime will catch up with the previous currentTime
            // where previous cT is of car ahead
            if(!stack.isEmpty() && currentTime <= stack.peek()) {
                continue;
            } else {
                stack.push(currentTime);
            }
        }

        return stack.size();
    }
}

public class LC853CarFleet {
    public static void main(String[] args) {
        int target = SystemUtils.takeIntInput("Enter the target: ");
        int[] position = SystemUtils.takeIntArrayInput("Enter position values: ");
        int[] speed = SystemUtils.takeIntArrayInput("Enter speed values: ");

        System.out.println("");
    }
}
