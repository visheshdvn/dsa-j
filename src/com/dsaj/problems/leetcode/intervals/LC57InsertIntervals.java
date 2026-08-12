package com.dsaj.problems.leetcode.intervals;

import java.util.Arrays;

class LC57InsertIntervalsSolution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length + 1][2];
        int i = 0, j = 0;

        // add all intervals that end before the new interval starts
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result[j++] = intervals[i++];
        }

        // merge overlaping intervals
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i++][0]);
        }

        result[j++] = newInterval;

        // add remaining intervals
        while (i < intervals.length) {
            result[j++] = intervals[i++];
        }

        return Arrays.copyOf(result, j);
    }
}

public class LC57InsertIntervals {
    public static void main(String[] args) {
        // interval = [[1,2],[3,5],[6,7],[8,10],[12,16]]
        // int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        // int[] newInterval = { 4, 8 };
        int[][] intervals = { { 1, 3 }, { 6, 9 } };
        int[] newInterval = { 2, 5 };

        int[][] updatedIntervals = new LC57InsertIntervalsSolution().insert(intervals, newInterval);

        System.out.println(updatedIntervals);
    }
}
