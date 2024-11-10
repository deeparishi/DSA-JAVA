package com.deeparishi.javaapp.leetcode.sorting;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {

        System.out.println(threeSumOptimal(new int[]{0, 1, 1}));

    }

    // Optimal Approach
    //
    static List<List<Integer>> threeSumOptimal(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) left++;
                else if (sum > 0) right--;
                else {
                    List<Integer> data = Arrays.asList(nums[i], nums[left], nums[right]);
                    res.add(data);
                    while (left < right && nums[left - 1] == nums[left]) left++;
                    while (left < right && nums[right + 1] == nums[right]) right--;
                }
            }
        }

        return res;
    }

    // O(N^2) Approach and O(N) for SC
    static List<List<Integer>> threeSumBetter(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                int third = -(nums[i] + nums[j]);
                if (map.containsKey(third)) {
                    List<Integer> re = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(re);
                    result.add(re);
                }
                map.put(nums[j], j);
            }
        }

        return new ArrayList<>(result);
    }

    // BruteForce Approach
    // O(N^3) TC Approach
    static List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> resultSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);
                        resultSet.add(triplet);
                    }
                }
            }
        }
        return new ArrayList<>(resultSet);
    }


    // Confusing Approach
    public List<List<Integer>> threeSumConfused(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set<String> used = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int curr = nums[i] + nums[j];
                if (map.containsKey(-1 * curr)) {
                    int k = map.get(-1 * curr);
                    if (!used.contains(nums[i] + ":" + nums[j] + ":" + nums[k]) && k > i && k > j) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        used.add(nums[i] + ":" + nums[j] + ":" + nums[k]);
                    }
                }
            }
        }

        return result;
    }

}