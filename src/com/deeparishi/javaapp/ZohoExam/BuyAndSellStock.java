package com.deeparishi.javaapp.ZohoExam;

public class BuyAndSellStock {

    public static void main(String[] args) {
        int arr[] = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else {
                int curr = price - min;
                max = Math.max(curr, max);
            }
        }
        return max;

    }

}
