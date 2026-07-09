package com.dsaj.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC40CombinationSum2Solution {
    Set<List<Integer>> combinations = new HashSet<>();

    private void combinationSum2Helper(int[] candidates, int target, int idx, List<Integer> combination, int total) {
        if(total == target) {
            List<Integer> l = new ArrayList<>(combination);
            combinations.add(l);
            return;
        }

        if(total > target || idx >= candidates.length) {
            return;
        }

        combination.add(candidates[idx]);
        combinationSum2Helper(candidates, target, idx+1, combination, total+candidates[idx]);
        
        combination.removeLast();
        while(idx+1 < candidates.length && candidates[idx] == candidates[idx+1]) {
            idx++;
        }
        combinationSum2Helper(candidates, target, idx+1, combination, total);
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, target, 0, new ArrayList<>(), 0);
        return new ArrayList<>(combinations);
    }
}

public class LC40CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = SystemUtils.takeIntArrayInput("Enter the elements of the candidates array (space-separated): ");
        int target = SystemUtils.takeIntInput("Enter the target sum: ");

        List<List<Integer>> result = new LC40CombinationSum2Solution().combinationSum2(candidates, target);

        System.out.println("All unique combinations of candidates that sum up to the target:");
        for (List<Integer> list : result) {
            ArrayUtils.printList(list);
        }
    }
}
