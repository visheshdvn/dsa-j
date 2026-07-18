// ⭐
// Topics: #monotonic-stack

package com.dsaj.problems.leetcode.stack;
import java.util.Stack;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.concepts.dsa.utils.SystemUtils;

class Pair {
    int num;
    int index;

    public Pair(int num, int index) {
        this.num = num;
        this.index = index;
    }
}

class LC739DailyTempraturesSolution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> stack = new Stack<>();
        int[] days = new int[temperatures.length];

        for (int i = temperatures.length - 1; i >= 0; i--) {
            // see if it needs to be pushed
            while (!stack.isEmpty() && stack.peek().num <= temperatures[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                days[i] = stack.peek().index - i;
            }

            stack.push(new Pair(temperatures[i], i));
        }

        return days;
    }
}

class LC739DailyTempraturesEfficientSolution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] days = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int ind = stack.pop();
                days[ind] = i - ind;
            }
            stack.push(i);
        }

        return days;
    }
}

public class LC739DailyTempratures {
    public static void main(String[] args) {
        LC739DailyTempraturesSolution solution = new LC739DailyTempraturesSolution();

        int[] tempratures = SystemUtils.takeIntArrayInput("Enter temprature values: ");

        int[] days = solution.dailyTemperatures(tempratures);

        ArrayUtils.printIntArray(days);
    }
}
