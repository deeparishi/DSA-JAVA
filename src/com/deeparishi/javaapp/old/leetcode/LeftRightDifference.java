package com.deeparishi.javaapp.old.leetcode;

import java.util.Arrays;

public class LeftRightDifference {
    public static void main(String[] args) {
        int [] arr = leftRightDifference(new int []{0});
        for (int i=0; i<arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }

    public static int[] leftRightDifference(int[] nums) {
        int [] leftSide = new int[nums.length];
        int [] rightSide = new int[nums.length];
        int [] result = new int[nums.length];
        leftSide[0] = 0;
        int leftInc=1;
        for(int left=0; left<=nums.length-2; left++)
        {
            int ans = leftSide[left] + nums[left];
            leftSide[leftInc] = ans;
            leftInc++;
        }
        rightSide[nums.length-1] = 0;
        int rightDec = nums.length-2;
        for(int right = nums.length-1; right>0; right--){
            int ans = rightSide[right] + nums[right];
            rightSide[rightDec--] = ans;
        }
        for(int res = 0; res<=nums.length-1; res++){
            int ans = leftSide[res]-rightSide[res];
            if(ans<0){
                int positiveNum = Math.abs(ans);
                result[res] = positiveNum;
            }
            else {
                result[res] = ans;
            }
        }


        return result;
    }
}
