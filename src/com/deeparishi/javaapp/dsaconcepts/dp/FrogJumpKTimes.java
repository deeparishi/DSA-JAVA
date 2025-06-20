package com.deeparishi.javaapp.dsaconcepts.dp;

import java.util.HashMap;
import java.util.Map;

public class FrogJumpKTimes {

    public static void main(String[] args) {


        int[] arr1 = {30, 10, 60, 10, 60, 50};
        System.out.println(frogJumpV1(arr1, arr1.length - 1, 7));
        System.out.println(frogJumpV2(arr1, arr1.length - 1, 2, new HashMap<>()));
    }


    public static int frogJumpV1(int[] arr, int len, int k) {

        if (len == 0) return 0;
        int max = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            if (len - i >= 0) {
                int min = frogJumpV1(arr, len - i, k) + Math.abs(arr[len] - arr[len - i]);
                max = Math.min(max, min);
            }
        }
        return max;
    }

    public static int frogJumpV2(int[] arr, int len, int k, Map<Integer, Integer> map) {

        if (len == 0) return 0;
        if(map.containsKey(len)) return map.get(len);

        int max = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            if (len - i >= 0) {
                int min = frogJumpV1(arr, len - i, k) + Math.abs(arr[len] - arr[len - i]);
                max = Math.min(max, min);
            }
        }
            map.put(len, max);
        return max;
    }
}
