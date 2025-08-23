package com.deeparishi.javaapp.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeInteger {

    public static void main(String[] args) {

        System.out.println(firstNegIntOptimal(new int[]{-8, 2, 3, -6, 10}, 2));
        System.out.println(firstNegIntOptimal(new int[]{12, -1, -7, 8, -15, 30, 16, 28}, 3));
        System.out.println(firstNegIntOptimal(new int[]{12, 1, 3, 5}, 3));
    }

    static List<Integer> firstNegIntBrute(int[] arr, int k) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= arr.length - k; i++) {
            boolean isFound = false;
            for (int j = i; j < i + k; j++) {
                int val = arr[j];
                if (val < 0) {
                    result.add(val);
                    isFound = true;
                    break;
                }
            }
            if (!isFound)
                result.add(0);
        }

        return result;
    }

    static List<Integer> firstNegIntOptimal(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int left = 0;
        int right = 0;
        int len = arr.length;

        while (right < len) {
            if (arr[right] < 0)
                queue.add(arr[right]);

            if (right - left + 1 < k)
                right++;

            else if (right - left + 1 == k) {

                if (!queue.isEmpty())
                    res.add(queue.peek());
                else
                    res.add(0);

                if (!queue.isEmpty() && queue.peek() == arr[left])
                    queue.poll();

                right++;
                left++;
            }
        }

        return res;
    }
}
