package com.deeparishi.javaapp.leetcode.slidingwindow;

// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

public class MaxPointsFromCards {

    public static void main(String[] args) {
        int[] one = {1,2,3,4,5,6,1};
        System.out.println(maxScore(one, 3));
    }

    public static int maxScore(int[] cardPoints, int k) {

        int leftSum = 0;
        int rightSum = 0;
        int maxSum = 0;

        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
            maxSum = leftSum;
        }

        int right = cardPoints.length - 1;

        for (int i = k - 1; i >= 0; i--) {
            leftSum -= cardPoints[i];
            rightSum += cardPoints[right];
            maxSum = Math.max(maxSum, leftSum + rightSum);
            right--;
        }

        return maxSum;
    }
}
