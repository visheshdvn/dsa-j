package com.dsaj.problems.leetcode.slidingwindow;

import java.util.Arrays;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC567PermutationInStringSolution {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        for (int i = 0; i < s1Arr.length; i++) {
            s1Count[s1Arr[i] - 'a']++;
            s2Count[s2Arr[i] - 'a']++;
        }

        if(Arrays.equals(s1Count, s2Count)) return true;

        for (int i = s1Arr.length; i < s2Arr.length; i++) {
            s2Count[s2Arr[i] - 'a']++;
            s2Count[s2Arr[i - s1Arr.length] - 'a']--;

            if(Arrays.equals(s1Count, s2Count)) return true;
        }

        return false;
    }
}

public class LC567PermutationInString {
    public static void main(String[] args) {
        LC567PermutationInStringSolution solution = new LC567PermutationInStringSolution();
        String s1 = SystemUtils.takeStringInput("Enter s1: ");
        String s2 = SystemUtils.takeStringInput("Enter s2: ");

        String result = "Permutation is " + (!solution.checkInclusion(s1, s2) ? "not " : "") + "present";
        System.out.println(result);
    }
}
