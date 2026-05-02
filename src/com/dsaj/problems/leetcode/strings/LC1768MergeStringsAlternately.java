package com.dsaj.problems.leetcode.strings;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC1768Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int i = 0, j = 0;
        int str1len = word1.length();
        int str2len = word2.length();
        
        while (i < str1len && j < str2len) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }

        while (i < str1len) {
            sb.append(word1.charAt(i++));
        }

        while (j < str2len) {
            sb.append(word2.charAt(j++));
        }

        return sb.toString();
    }
}

public class LC1768MergeStringsAlternately {

    public static void main(String[] args) {
        LC1768Solution solution = new LC1768Solution();

        String str1 = SystemUtils.takeStringInput("Enter first string: ");
        String str2 = SystemUtils.takeStringInput("Enter second string: ");

        String newStr = solution.mergeAlternately(str1, str2);
        System.out.println("Merged string: " + newStr);
    }
}