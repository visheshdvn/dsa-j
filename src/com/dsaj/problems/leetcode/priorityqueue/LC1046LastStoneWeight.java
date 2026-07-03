package com.dsaj.problems.leetcode.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC1046Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) {
            return stones[0];
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() != 1) {
            int w1 = maxHeap.poll();
            int w2 = maxHeap.poll();

            maxHeap.offer(w1-w2);
        }

        return maxHeap.peek();
    }
}

public class LC1046LastStoneWeight {
    public static void main(String[] args) {
        int[] arr = SystemUtils.takeIntArrayInput("Enter stone weights");
        LC1046Solution solution = new LC1046Solution();
        System.out.println(solution.lastStoneWeight(arr));
    }
}
