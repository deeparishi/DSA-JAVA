package com.deeparishi.javaapp.old.leetcode;

import java.util.*;

public class MinIndexOfTwoList {
    public static String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> mapRestaurant = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(int i=0; i<list1.length; i++){
            mapRestaurant.put(list1[i], i);
        }

        int maxValue = Integer.MAX_VALUE;
        for (int i=0; i<list2.length; i++){
            if(mapRestaurant.containsKey(list2[i])){
                int indexSum = mapRestaurant.get(list2[i])+i;

                if(indexSum < maxValue){
                    result.clear();
                    result.add(list2[i]);
                    maxValue = indexSum;
                }else if (indexSum == maxValue){
                    result.add(list2[i]);
                }
            }
        }

        return result.toArray(new String[result.size()]);
    }


    public static void main(String[] args) {
        String[] list1 = {"happy","sad","good"};
        String[] list2 = {"sad","happy","good"};

        String[] result = findRestaurant(list1, list2);
        System.out.println(Arrays.toString(result));  // Output: ["Shogun"]
    }
}
