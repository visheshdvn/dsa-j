package com.dsaj.problems.leetcode.dp;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC5LongestPalindromicSubstringSolution {
    private String helper(char[] str, int start, int end) {
        while (0 <= start && end < str.length && str[start] == str[end]) {
            start--;
            end++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = start + 1; i < end; i++) {
            sb.append(str[i]);
        }

        return sb.toString();
    }

    public String longestPalindrome(String s) {
        char[] str = s.toCharArray();

        String longest = "";

        for (int i = 0; i < str.length; i++) {
            String s1 = helper(str, i, i);
            String s2 = helper(str, i, i + 1);

            if (longest.length() < s1.length()) {
                longest = s1;
            }

            if (longest.length() < s2.length()) {
                longest = s2;
            }
        }

        return longest;
    }
}

public class LC5LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = SystemUtils.takeStringInput("Enter the string: ");

        System.out.println("Longest substring : " + new LC5LongestPalindromicSubstringSolution().longestPalindrome(s));
    }
}
