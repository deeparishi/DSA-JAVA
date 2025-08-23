package com.deeparishi.javaapp.leetcode.arrays;

// https://www.hackerearth.com/problem/algorithm/maximum-in-subarray/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class MaxInSubArray {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read N and K
        String[] nk = br.readLine().split(" ");
        int N = Integer.parseInt(nk[0]);
        int K = Integer.parseInt(nk[1]);

        // Read array elements
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        // Deque to store indices
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - K) {
                dq.pollFirst();
            }

            // Remove smaller elements (they are useless)
            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.pollLast();
            }

            // Add current element at the back of deque
            dq.offerLast(i);

            // Print the max of current window
            if (i >= K - 1) {
                System.out.print(arr[dq.peekFirst()] + " ");
            }
        }
    }
}
