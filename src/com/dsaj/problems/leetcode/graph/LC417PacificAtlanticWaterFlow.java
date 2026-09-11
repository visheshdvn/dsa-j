package com.dsaj.problems.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

import com.dsaj.concepts.dsa.utils.ArrayUtils;

class LC417PacificAtlanticWaterFlowSolution {
    private void mark(int[][] flow, int[][] heights, int i, int j, int digit) {
        if (flow[i][j] == digit) {
            return;
        }

        flow[i][j] = digit;

        if (i + 1 < heights.length && heights[i + 1][j] >= heights[i][j]) {
            mark(flow, heights, i + 1, j, digit);
        }

        if (i - 1 >= 0 && heights[i - 1][j] >= heights[i][j]) {
            mark(flow, heights, i - 1, j, digit);
        }

        if (j + 1 < heights[0].length && heights[i][j + 1] >= heights[i][j]) {
            mark(flow, heights, i, j + 1, digit);
        }

        if (0 <= j - 1 && heights[i][j - 1] >= heights[i][j]) {
            mark(flow, heights, i, j - 1, digit);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        // for atlantic
        int[][] flowAtlantic = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            mark(flowAtlantic, heights, i, cols - 1, 1);
        }

        for (int i = 0; i < cols; i++) {
            mark(flowAtlantic, heights, rows - 1, i, 1);
        }

        // for pacific
        int[][] flowPacific = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            mark(flowPacific, heights, i, 0, 1);
        }

        for (int i = 0; i < cols; i++) {
            mark(flowPacific, heights, 0, i, 1);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (flowAtlantic[i][j] == 1 && flowPacific[i][j] == 1) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }
}

class LC417PacificAtlanticWaterFlowMemoryEfficientSolution {

    private void markForAtlantic(int[][] flow, int[][] heights, int i, int j, int digit) {
        if (flow[i][j] == digit) {
            return;
        }

        flow[i][j] = digit;

        if (i + 1 < heights.length && heights[i + 1][j] >= heights[i][j]) {
            markForAtlantic(flow, heights, i + 1, j, digit);
        }

        if (i - 1 >= 0 && heights[i - 1][j] >= heights[i][j]) {
            markForAtlantic(flow, heights, i - 1, j, digit);
        }

        if (j + 1 < heights[0].length && heights[i][j + 1] >= heights[i][j]) {
            markForAtlantic(flow, heights, i, j + 1, digit);
        }

        if (0 <= j - 1 && heights[i][j - 1] >= heights[i][j]) {
            markForAtlantic(flow, heights, i, j - 1, digit);
        }
    }

    private void markForPacific(int[][] flow, int[][] heights, int i, int j, int digit) {
        if (flow[i][j] == digit || flow[i][j] == 3) {
            return;
        }

        if (flow[i][j] == 1) {
            flow[i][j] = digit;
        } else {
            flow[i][j] = 3;
        }

        if (i + 1 < heights.length && heights[i + 1][j] >= heights[i][j]) {
            markForPacific(flow, heights, i + 1, j, digit);
        }

        if (0 <= i - 1 && heights[i - 1][j] >= heights[i][j]) {
            markForPacific(flow, heights, i - 1, j, digit);
        }

        if (j + 1 < heights[0].length && heights[i][j + 1] >= heights[i][j]) {
            markForPacific(flow, heights, i, j + 1, digit);
        }

        if (0 <= j - 1 && heights[i][j - 1] >= heights[i][j]) {
            markForPacific(flow, heights, i, j - 1, digit);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] flow = new int[rows][cols];
        
        // for atlantic
        for (int i = 0; i < rows; i++) {
            markForAtlantic(flow, heights, i, cols - 1, 1);
        }

        for (int i = 0; i < cols; i++) {
            markForAtlantic(flow, heights, rows - 1, i, 1);
        }

        // for pacific
        for (int i = 0; i < rows; i++) {
            markForPacific(flow, heights, i, 0, 2);
        }

        for (int i = 0; i < cols; i++) {
            markForPacific(flow, heights, 0, i, 2);
        }

        // prepare the result
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (flow[i][j] == 2) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }
}

public class LC417PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int[][] heights = {
                { 1, 2, 2, 3, 5 },
                { 3, 2, 3, 4, 4 },
                { 2, 4, 5, 3, 1 },
                { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 }
        };

        List<List<Integer>> result = new LC417PacificAtlanticWaterFlowMemoryEfficientSolution().pacificAtlantic(heights);

        // print the result
        System.out.println("Cells where water can flow to both the Pacific and Atlantic oceans:");
        for (List<Integer> cell : result) {
            ArrayUtils.printList(cell);
        }
    }
}
