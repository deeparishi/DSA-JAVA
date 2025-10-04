package com.deeparishi.javaapp.leetcode.dp;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

public class BuyAndSellStocksII {

    // 0 - Sell and 1 - Buy

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2];
        return maxProfitWithoutDP(prices, 0, true);
//        return maxProfitWithDp(prices, 0, 1, dp);
    }

    public static int maxProfitWithoutDP(int[] prices, int idx,
                                         boolean buy) {

        if (idx == prices.length)
            return 0;

        int profit;
        if (buy) {
            int buyAndMove = -prices[idx] + maxProfitWithoutDP(prices, idx + 1, true); // I can buy or
            int skipAndMove = maxProfitWithoutDP(prices, idx + 1, false); // I can skip
            profit = Math.max(buyAndMove, skipAndMove);
        } else {
            int sellAndMove = prices[idx] + maxProfitWithoutDP(prices, idx + 1, true); // I can sell or
            int skipAndMove = maxProfitWithoutDP(prices, idx + 1, false); // I can skip
            profit = Math.max(skipAndMove, sellAndMove);
        }

        return profit;
    }

    public static int maxProfitWithDp(int[] prices, int idx,
                                         int buy, Integer[][] dp) {

        if (idx == prices.length)
            return 0;

        if (dp[idx][buy] != null)
            return (dp[idx][buy]);

        int profit;
        if (buy == 1) {
            int b = -prices[idx] + maxProfitWithDp(prices, idx + 1, 0, dp); // I can buy or
            int skip = maxProfitWithDp(prices, idx + 1, 1, dp); // I can skip
            profit = Math.max(b, skip);
        } else {
            int sell = prices[idx] + maxProfitWithDp(prices, idx + 1, 1, dp); // I can sell or
            int skip = maxProfitWithDp(prices, idx + 1, 0, dp); // I can skip
            profit = Math.max(skip, sell);
        }

        return dp[idx][buy] = profit;
    }

}
