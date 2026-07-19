package com.dsaj.problems.leetcode.slidingwindow;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC424LongestRepeatingCharacterReplacementSolution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int maxWindow = 0;

        for (int right = 0; right < s.length(); right++) {
            // update frequency map
            freq[s.charAt(right) - 'A']++;

            // update max frequency
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            int windowLength = right - left + 1;


            // if windowLength - max freq > k
            // shrink the window
            if(windowLength - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;

                windowLength = right - left + 1;
            }

            maxWindow = Math.max(maxWindow, windowLength);
        }

        return maxWindow;
    }
}

public class LC424LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        LC424LongestRepeatingCharacterReplacementSolution solution = new LC424LongestRepeatingCharacterReplacementSolution();

        String s = SystemUtils.takeStringInput("Enter the string: ");
        int k = SystemUtils.takeIntInput("Enter number of operations (k): ");

        System.out.println("length of longest substring: " + solution.characterReplacement(s, k));
    }
}
