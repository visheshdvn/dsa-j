package com.dsaj.problems.leetcode.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC846HandOfStraightsSolution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        Arrays.sort(hand);

        for (int card : hand) {
            if (countMap.get(card) == 0) {
                continue;
            }

            for (int i = 0; i < groupSize; i++) {
                int currentCard = card + i;
                if (!countMap.containsKey(currentCard) || countMap.get(currentCard) == 0) {
                    return false;
                }
                countMap.put(currentCard, countMap.get(currentCard) - 1);
            }
        }

        return true;
    }
}

public class LC846HandOfStraights {
    public static void main(String[] args) {
        int[] hand = SystemUtils.takeIntArrayInput("Enter hand values: ");
        int groupSize = SystemUtils.takeIntInput("Enter group size: ");

        System.out.println("Hand of Straight: " + new LC846HandOfStraightsSolution().isNStraightHand(hand, groupSize));
    }
}
