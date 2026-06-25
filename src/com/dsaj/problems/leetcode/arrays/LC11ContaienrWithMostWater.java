package com.dsaj.problems.leetcode.arrays;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC11ContainerWithMostWaterSolution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int area = 0;

        while (i < j) {
            area = Math.max(area, (j-i)*Math.min(height[i], height[j]));

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return area;
    }
}

public class LC11ContaienrWithMostWater {
    public static void main(String[] args) {
        LC11ContainerWithMostWaterSolution solution = new LC11ContainerWithMostWaterSolution();
        
        int[] height = SystemUtils.takeIntArrayInput("Enter the height array: ");
        int maxArea = solution.maxArea(height);
        System.out.println("The maximum area of water that can be contained is: " + maxArea);
    }
}