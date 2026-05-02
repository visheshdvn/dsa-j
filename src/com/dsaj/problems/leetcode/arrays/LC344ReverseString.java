package com.dsaj.problems.leetcode.arrays;

import com.dsaj.concepts.dsa.utils.SystemUtils;


class LC344Solution {
    private void swap(char[] s, int l, int r) {
        char t = s[l];
        s[l] = s[r];
        s[r] = t;
    }

    public void reverseString(char[] s) {
        int half = s.length / 2;

        for (int i = 0; i < half; i++) {
            swap(s, i, s.length-1-i);
        }
    }
}

public class LC344ReverseString {


    public static void main(String[] args) {
        LC344Solution solution = new LC344Solution();

        String str = SystemUtils.takeStringInput("Enter the string : ");
        char[] arr = str.toCharArray();

        solution.reverseString(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
    }
}
