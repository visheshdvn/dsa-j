package com.dsaj.problems.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC217Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int presentAt = map.getOrDefault(nums[i], -1);

            if (presentAt != -1) {
                return true;
            }

            map.put(nums[i], i);
        }

        return false;
    }
}

public class LC217ContainsDuplicates {
    public static void main(String[] args) {
        LC217Solution solution = new LC217Solution();

        int[] array = SystemUtils.takeIntArrayInput("Enter Array Elements: ");

        System.out.println("Dulplicates present: " + solution.containsDuplicate(array));
    }
}
