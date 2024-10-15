package com.deeparishi.javaapp.leetcode.arrays;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

        System.out.println(threeSum(new int[] {-1,0,1,2,-1,-4}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set<String> used = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <nums.length ; j++) {
                int curr = nums[i] + nums[j];
                if(map.containsKey(-1 *curr)){
                    int k = map.get( -1 * curr);
                    if(!used.contains(STR."\{nums[i]}:\{nums[j]}:\{nums[k]}") && k > i && k > j){
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        used.add(STR."\{nums[i]}:\{nums[j]}:\{nums[k]}");
                    }
                }
            }
        }

        return result;
    }
}
