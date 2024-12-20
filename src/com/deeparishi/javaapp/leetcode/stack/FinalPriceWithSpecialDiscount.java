package com.deeparishi.javaapp.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/submissions/1481666415/?envType=daily-question&envId=2024-12-18

public class FinalPriceWithSpecialDiscount {

    public static void main(String[] args) {
        int[] prices = new int[]{8,4,6,2,3};
        System.out.println(Arrays.deepToString(finalPrices(prices)));
    }

    public static Object[] finalPrices(int[] prices) {

        int n = prices.length;
        int[] answer = prices.clone();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int topIndex = stack.pop();
                answer[topIndex] -= prices[i];
            }
            stack.push(i);
        }

        return new int[][]{answer};
    }
}
