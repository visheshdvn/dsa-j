package com.dsaj.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC90Subsets2Solution {
    List<List<Integer>> result = new ArrayList<>();

    private void subsetsHelper(int[] nums, List<Integer> currentSet, int start) {
        result.add(new ArrayList<>(currentSet));

        int i = start;
        while (i < nums.length) {
            currentSet.add(nums[i]);
            subsetsHelper(nums, currentSet, i+1);
            currentSet.removeLast();

            while (i < nums.length-1 && nums[i+1] == nums[i]) {
                i++;
            }
            i++;
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsetsHelper(nums, new ArrayList<>(), 0);
        return result;
    }
}

public class LC90Subsets2 {
    public static void main(String[] args) {
        int[] nums = SystemUtils.takeIntArrayInput("Enter the elements of the array (space-separated): ");
        List<List<Integer>> result = new LC90Subsets2Solution().subsetsWithDup(nums);

        for (List<Integer> list : result) {
            ArrayUtils.printList(list);
        }
    }
}
