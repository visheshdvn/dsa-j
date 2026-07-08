// ⭐️

package com.dsaj.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC39CombinationSumSolution {
    List<List<Integer>> combinations = new ArrayList<>();

    private void combinationSumHelper(int[] candidates, int target, int idx, List<Integer> combination, int total) {
        if(total == target) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        if(total > target || idx >= candidates.length) {
            return;
        }

        combination.add(candidates[idx]);
        combinationSumHelper(candidates, target, idx, combination, total + candidates[idx]);

        combination.removeLast();
        combinationSumHelper(candidates, target, idx+1, combination, total);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSumHelper(candidates, target, 0, new ArrayList<>(), 0);

        return combinations;
    }
}

public class LC39CombinationSum {
    public static void main(String[] args) {
        int[] candidates = SystemUtils.takeIntArrayInput("Enter the elements of the candidates array (space-separated): ");
        int target = SystemUtils.takeIntInput("Enter the target sum: ");

        List<List<Integer>> result = new LC39CombinationSumSolution().combinationSum(candidates, target);

        System.out.println("All unique combinations of candidates that sum up to the target:");
        for (List<Integer> list : result) {
            ArrayUtils.printList(list);
        }
    }
}