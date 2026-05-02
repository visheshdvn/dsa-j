package com.dsaj.problems.leetcode.strings;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC541SolutionNaive {

    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            if(i + k > s.length()) {
                int j = s.length()-1;
                while (i <= j) {
                    sb.append(s.charAt(j--));
                }
                return sb.toString();
            }

            for (int j = i+k-1; j >= i; j--) {
                sb.append(s.charAt(j));
            }

            for (int j = i+k; j < i+2*k && j < s.length(); j++) {
                sb.append(s.charAt(j));
            }

            i+=2*k;
        }

        return sb.toString();
    }
}

/*
Thoughts: 
converting string to char array for manipulation is better than using string builder
 */
class LC541Solution {
    private void swap(char[] s, int l, int r) {
        char t = s[l];
        s[l] = s[r];
        s[r] = t;
    }

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i+=2*k) {

            int low = i;
            int high = Math.min(i+k-1, s.length()-1);

            while (low < high) {
                swap(arr, low++, high--);
            }
        }

        return new String(arr);
    }
}

public class LC541reverseString2 {
    public static void main(String[] args) {
        LC541Solution solution = new LC541Solution();

        String s = SystemUtils.takeStringInput("Enter the string: ");
        int k = SystemUtils.takeIntInput("Enter k value: ");

        String updated = solution.reverseStr(s, k);
        System.out.println("updated string: " + updated);
    }
}
