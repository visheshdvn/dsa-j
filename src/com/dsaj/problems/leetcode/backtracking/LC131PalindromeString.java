package com.dsaj.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC131PalindromeStringSolution {
    public boolean isPalindrome(String s, int start, int end) {
        while (start <= end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }

        return start > end;
    }

    private void backtrack(String s, int start, List<String> currentList, List<List<String>> result) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(currentList));
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                currentList.add(s.substring(start, i+1));
                backtrack(s, i + 1, currentList, result);
                currentList.removeLast();
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
}

public class LC131PalindromeString {
    public static void main(String[] args) {
        LC131PalindromeStringSolution solution = new LC131PalindromeStringSolution();

        String str = SystemUtils.takeStringInput("Enter the string: ");

        List<List<String>> partitions = solution.partition(str);

        System.out.println("Partitions -");

        for (List<String> list : partitions) {
            ArrayUtils.printList(list);
        }
    }
}
