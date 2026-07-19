// ⭐

// Topics: #linked-list


package com.dsaj.problems.leetcode.linkedlist;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC287FindTheDuplicateNumberSolution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        // start fast & slow pinters until they meet
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);


        // when they meet, move both the pointers
        // at same speed until they meet agn.
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}

public class LC287FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = SystemUtils.takeIntArrayInput("Enter the numbers: ");

        System.out.println("Duplicate number: " + new LC287FindTheDuplicateNumberSolution().findDuplicate(nums));
    }
}
