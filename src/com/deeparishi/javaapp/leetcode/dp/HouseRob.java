package com.deeparishi.javaapp.leetcode.dp;

// https://leetcode.com/problems/house-robber/

public class HouseRob {

    public static void main(String[] args) {
        System.out.println(robV2(new int[]{1,2,3,1}));
        System.out.println(robV2(new int[]{2,7,9,3,1}));
        System.out.println(robV2(new int[]{2,1,1,2}));
    }


    public static int robV2(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(
                    dp[i - 1],
                    nums[i] + dp[i - 2]
            );
        }

        return dp[nums.length - 1];
    }

    public static int robV3(int[] nums) {
        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        for (int money : nums) {
            int curr = Math.max(prev1, money + prev2);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
