package com.dsaj.problems.leetcode.arrays;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC121BestTimeToBuyAndSellStockSolution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}

public class LC121BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        LC121BestTimeToBuyAndSellStockSolution solution = new LC121BestTimeToBuyAndSellStockSolution();
        
        int[] prices = SystemUtils.takeIntArrayInput("Enter the prices array: ");
        int maxProfit = solution.maxProfit(prices);
        System.out.println("The maximum profit that can be achieved is: " + maxProfit);
    }
}
