package com.dsaj.concepts.dsa.dp;

import java.util.Arrays;

import com.dsaj.concepts.dsa.utils.SystemUtils;

interface LCSSolution {
    int lcs(String str1, String str2);
}

class LCSRecursiveSolution implements LCSSolution {

    private int lcsHelper(String str1, String str2, int pos1, int pos2) {
        if (pos1 >= str1.length() || pos2 >= str2.length()) {
            return 0;
        }

        if (str1.charAt(pos1) == str2.charAt(pos2)) {
            return 1 + lcsHelper(str1, str2, pos1 + 1, pos2 + 1);
        } else {
            int l1 = lcsHelper(str1, str2, pos1, pos2 + 1);
            int l2 = lcsHelper(str1, str2, pos1 + 1, pos2);

            return Math.max(l1, l2);
        }
    }

    public int lcs(String str1, String str2) {
        return lcsHelper(str1, str2, 0, 0);
    }
}

class LCSMemoizationSolution implements LCSSolution {

    private int lcsHelper(String str1, String str2, int pos1, int pos2, int[][] memo) {
        if (pos1 >= str1.length() || pos2 >= str2.length()) {
            return 0;
        }

        if (memo[pos1][pos2] != -1) {
            return memo[pos1][pos2];
        }

        if (str1.charAt(pos1) == str2.charAt(pos2)) {
            memo[pos1][pos2] = 1 + lcsHelper(str1, str2, pos1 + 1, pos2 + 1, memo);
            return memo[pos1][pos2];
        } else {
            int l1 = lcsHelper(str1, str2, pos1, pos2 + 1, memo);
            int l2 = lcsHelper(str1, str2, pos1 + 1, pos2, memo);

            memo[pos1][pos2] = Math.max(l1, l2);
            return memo[pos1][pos2];
        }
    }

    public int lcs(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();

        int[][] memo = new int[l1][l2];

        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        return lcsHelper(str1, str2, 0, 0, memo);
    }
}

class LCSDynamicProgrammingSolution implements LCSSolution {

    public int lcs(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();

        int[][] memo = new int[l1][l2];

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    memo[i][j] = 1 + (i - 1 < 0 || j - 1 < 0 ? 0 : memo[i - 1][j - 1]);
                } else {
                    int max1 = i - 1 < 0 ? 0 : memo[i - 1][j];
                    int max2 = j - 1 < 0 ? 0 : memo[i][j - 1];

                    memo[i][j] = Math.max(max1, max2);
                }
            }
        }

        return memo[l1 - 1][l2 - 1];
    }
}

public class LCS {
    public static void main(String[] args) {
        LCSSolution recursiveSolution = new LCSRecursiveSolution();
        LCSSolution memoizationSolution = new LCSMemoizationSolution();
        LCSSolution dynamicProgrammingSolution = new LCSDynamicProgrammingSolution();

        String str1 = SystemUtils.takeStringInput("Enter first string: ");
        String str2 = SystemUtils.takeStringInput("Enter second string: ");

        int ans;

        Long startTime = System.currentTimeMillis();
        ans = recursiveSolution.lcs(str1, str2);
        System.out.println("Longest subsequence length: " + ans);
        Long endTime = System.currentTimeMillis();
        System.out.println("Time taken for recursive solution: " + (endTime - startTime) + " ms");

        Long memoStartTime = System.currentTimeMillis();
        ans = memoizationSolution.lcs(str1, str2);
        System.out.println("Longest subsequence length: " + ans);
        Long memoEndTime = System.currentTimeMillis();
        System.out.println("Time taken for memoization solution: " + (memoEndTime - memoStartTime) + " ms");

        Long dpStartTime = System.currentTimeMillis();
        ans = dynamicProgrammingSolution.lcs(str1, str2);
        System.out.println("Longest subsequence length: " + ans);
        Long dpEndTime = System.currentTimeMillis();
        System.out.println("Time taken for dynamic programming solution: " + (dpEndTime - dpStartTime) + " ms");
    }
}
