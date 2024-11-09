package com.deeparishi.javaapp.selfpractice.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 6, 7, 4, 5,3, 8};
        int[] sorted = countSortUsingMap(arr);
        System.out.println(Arrays.toString(sorted));
    }

    private static int[] countSort(int[] arr) {

        int max = arr[0];

        for (Integer i : arr){
            if(i > max)
                max = i;
        }

        int[] frequency = new int[max + 1];

        for (int num : arr)
            frequency[num]++;

        int indx = 0;
        for (int i = 0; i <= max; i++) {
            while (frequency[i] > 0){
                arr[indx] = i;
                indx++;
                frequency[i]--;
            }
        }

        return arr;
    }


    static int[] countSortUsingMap(int[] arr){

        int max = arr[0];

        for (int num : arr){
            if(num > max) max = num;
        }

        Map<Integer, Integer> freq = new HashMap<>();

        for (int j : arr) {
            freq.put(j, freq.getOrDefault(j, 0) + 1);
        }

        int idx = 0;
        for (int i = 0; i <= max; i++){
            while (freq.get(i) != null && freq.get(i) > 0){
                arr[idx] = i;
                idx++;
                freq.put(i, freq.get(i) - 1);
            }
        }

        return arr;
    }
}
