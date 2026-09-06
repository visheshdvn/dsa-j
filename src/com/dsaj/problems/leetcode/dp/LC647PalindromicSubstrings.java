package com.dsaj.problems.leetcode.dp;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC647PalindromicSubstringsSolution {

    private int countPalindromes(char[] str, int start, int end) {
        int count = 0;

        while (0 <= start && end < str.length && str[start] == str[end]) {
            count++;
            start--;
            end++;
        }

        return count;
    }

    public int countSubstrings(String s) {
        char[] string = s.toCharArray();
        int count = 0;

        for (int i = 0; i < string.length; i++) {
            count += countPalindromes(string, i, i);
            count += countPalindromes(string, i, i + 1);
        }

        return count;
    }
}

public class LC647PalindromicSubstrings {
    public static void main(String[] args) {
        String s = SystemUtils.takeStringInput("Enter the string: ");

        System.out.println("Count of palindromic substrings : " + new LC647PalindromicSubstringsSolution().countSubstrings(s));
    }
}
