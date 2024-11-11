package com.deeparishi.javaapp.leetcode.sorting;

import java.util.*;

public class ArrayCanBeSorted {

    public static void main(String[] args) {
        System.out.println(canSortArray(new int[]{20, 16}));

    }

    static boolean canSortArray(int[] nums) {

        boolean flag = true;
        for (int i = 0; i < nums.length- 1; i++) {
            if (nums[i] > nums[i + 1]) {
                flag = false;
                break;
            }
        }

        if(flag) return true;

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int num : nums) {

            int countOfOne = 0;
            String binary = Integer.toBinaryString(num);

            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(j) == '1')
                    countOfOne++;
            }

            map.putIfAbsent(countOfOne, new ArrayList<>());
            map.get(countOfOne).add(num);
        }

        List<Integer> mergedList = new ArrayList<>();

        for (List<Integer> v : map.values()){
            Collections.sort(v);
            mergedList.addAll(v);
        }

        for (int i = 0; i < mergedList.size() - 1; i++) {
            if(mergedList.get(i) > mergedList.get(i + 1))
                return false;
        }

        return true;
    }

//    static boolean optimizedSort(int[] arr){
//        boolean flag = true;
//        for (int i = 0; i < nums.length- 1; i++) {
//            if (nums[i] > nums[i + 1]) {
//                flag = false;
//                break;
//            }
//        }
//
//        if(flag) return true;
//    }
}
