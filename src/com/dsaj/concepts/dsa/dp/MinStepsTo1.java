package com.dsaj.concepts.dsa.dp;

import java.time.Instant;

import com.dsaj.concepts.dsa.utils.SystemUtils;

public class MinStepsTo1 {

    /*
    Brute force - slightly optimized
     */
    private static int minStepsTo1(int n, int[] count) {
        if(n == 1) {
            if(count[0] < count[1]) {
                count[1] = count[0];
            }

            return count[0];
        }

        if(n < 1 || count[0] > count[1]) {
            return Integer.MAX_VALUE;
        }

        int way1, way2, way3;
        way1 = way2 = way3 = Integer.MAX_VALUE;
        
        if(n % 3 == 0) {
            way1 = minStepsTo1(n/3, new int[]{count[0]+1, count[1]});
        }

        if(n % 2 == 0) {
            way2 = minStepsTo1(n/2, new int[]{count[0]+1, count[1]});
        }
        
        way3 = minStepsTo1(n-1, new int[]{count[0]+1, count[1]});

        return Math.min(way1, Math.min(way2, way3));
    }

    /*
    Memoization technique
     */
    private static int minStepsTo1Memoization(int n, int[] steps) {
        if(n <= 1) {
            return 0;
        }

        if(steps[n] != -1) {
            return steps[n];
        }

        int count1, count2, count3;
        count1 = count2 = count3 = Integer.MAX_VALUE;

        if(n % 3 == 0) {
            count1 = minStepsTo1Memoization(n/3, steps);
        }

        if(n % 2 == 0) {
            count2 = minStepsTo1Memoization(n/2, steps);
        }

        count3 = minStepsTo1Memoization(n-1, steps);

        steps[n] = 1 + Math.min(count1, Math.min(count2, count3));

        return steps[n];
    }


    /*
    DP technique
     */
    private static int minStepsTo1DP(int n) {
        int[] steps = new int[n+1];
        steps[1] = 0;

        for (int i = 2; i < steps.length; i++) {
            int min = Integer.MAX_VALUE;

            if(i%3 == 0) {
                min = Math.min(min, steps[i/3]);
            }

            if(i%2 == 0) {
                min = Math.min(min, steps[i/2]);
            }

            min = Math.min(min, steps[i-1]);
            
            steps[i] = 1 + min;
        }

        return steps[steps.length-1];
    }


    public static void main(String[] args) {
        int n = SystemUtils.takeIntInput("Enter value of n: ");

        Instant start = Instant.now();
        int[] count = new int[] {0, Integer.MAX_VALUE};
        System.out.println("Min steps normal: " + minStepsTo1(n, count));
        System.out.println("Time taken without memoization: " + (Instant.now().toEpochMilli() - start.toEpochMilli()) + " ms");

        System.out.println("\n\n");

        int[] steps = new int[n+1];
        for (int i = 0; i < steps.length; i++) {
            steps[i] = -1;
        }
        start = Instant.now();
        System.out.println("Min steps with memoization: " + minStepsTo1Memoization(n, steps));
        System.out.println("Time taken with memoization: " + (Instant.now().toEpochMilli() - start.toEpochMilli()) + " ms");

        System.out.println("\n\n");

        start = Instant.now();
        System.out.println("Min steps withDP: " + minStepsTo1DP(n));
        System.out.println("Time taken with DP: " + (Instant.now().toEpochMilli() - start.toEpochMilli()) + " ms");
    }
}