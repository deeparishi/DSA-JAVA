package com.deeparishi.javaapp.leetcode.graph.shortestpath.dijikistra;

//https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationsToReachEnd {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 5, 7};
        System.out.println(minimumMultiplications(arr, 3, 30));
    }

    private static int minimumMultiplications(int[] arr, int start, int end) {

        int mod = 10000;

        if (start == end)
            return 0;

        int[] distance = new int[mod];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});

        while (!queue.isEmpty()) {

            int[] poll = queue.poll();
            int node = poll[0];
            int dist = poll[1];

            for (int val : arr) {

                int nxt = (node * val) % mod;

                if (dist + 1 < distance[nxt]) {
                    distance[nxt] = dist + 1;

                    if (nxt == end)
                        return dist + 1;

                    queue.add(new int[]{nxt, dist + 1});
                }
            }
        }

        return -1;
    }
}