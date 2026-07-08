package com.dsaj.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC78SubsetsSolution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> newSets = new ArrayList<>();

            for (List<Integer> list : subsets) {
                List<Integer> n = new ArrayList<>(list);
                n.add(nums[i]);
                newSets.add(n);
            }

            for (List<Integer> list : newSets) {
                subsets.add(list);
            }
        }

        return subsets;
    }
}

class LC78SubsetsBackTrackingSolution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}

public class LC78Subsets {
    public static void main(String[] args) {
        LC78SubsetsBackTrackingSolution solution = new LC78SubsetsBackTrackingSolution();
        int[] nums = SystemUtils.takeIntArrayInput("Enter the elements of the array (space-separated): ");

        List<List<Integer>> result = solution.subsets(nums);

        System.out.println("All subsets of the given array:");
        for (List<Integer> subset : result) {
            ArrayUtils.printList(subset);
        }
    }
}
