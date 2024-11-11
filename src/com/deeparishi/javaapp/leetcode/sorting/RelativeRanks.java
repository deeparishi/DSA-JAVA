package com.deeparishi.javaapp.leetcode.sorting;

import java.util.*;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class RelativeRanks {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{10, 3, 8, 9, 4})));
//        System.out.println(Arrays.toString(findRelativeRanks(new int[]{5,4,3,2,1})));
//        System.out.println(Arrays.toString(findRelativeRanks(new int[]{10,3,8,9,4})));


    }

    static String[] findRelativeRanks(int[] score) {

        int[] sorted = new int[score.length];
        System.arraycopy(score, 0, sorted, 0, score.length);
        Arrays.sort(sorted);

        String[] result = new String[score.length];

        for (int i = 0;  i < score.length; i++) {

            int rank = score.length - binarySearch(sorted, score[i]);

            switch (rank){
                case 1:
                    result[i] = "Gold Medal";
                    break;
                case 2:
                    result[i] = "Silver Medal";
                    break;
                case 3:
                    result[i] = "Bronze Medal";
                    break;
                default:
                    result[i] = String.valueOf(rank);
                    break;
            }
        }

        return result;

    }

    private static int binarySearch(int[] sorted, int target) {

        int start = 0;
        int end = sorted.length - 1;

        while (start <= end){

            int mid = start + (end - start) / 2;

            if(sorted[mid] == target)
                return mid;

            if(sorted[mid] < target)
                start = mid + 1;

            else
                end = mid - 1;
        }

        return -1;
    }


}