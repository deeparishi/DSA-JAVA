package com.deeparishi.javaapp.leetcode.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
//https://leetcode.com/problems/majority-element/description/?envType=problem-list-v2&envId=sorting

public class MajorityElementI {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    static int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int threshold = nums.length / 2;

       Set<Integer> data = Arrays.stream(nums).boxed().collect(Collectors.toSet());
       int max = 0;

       for (int d : data){
           int count = map.get(d);
           if(count > threshold && count > max)
               max = d;
       }

       return max;



    }
}
