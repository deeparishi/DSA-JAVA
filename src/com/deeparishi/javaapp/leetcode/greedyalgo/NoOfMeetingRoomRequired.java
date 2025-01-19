package com.deeparishi.javaapp.leetcode.greedyalgo;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NoOfMeetingRoomRequired {

    public static void main(String[] args) {

        int[][] a = {
                {0, 30},
                {5, 10},
                {15, 20}
        };

        System.out.println(countRooms(a));

        int[][] b = {
                {7, 10},
                {2, 4},
        };

        System.out.println(countRooms(b));
    }

    public static int countRooms(int[][] meetings) {

        Arrays.sort(meetings, (arr1, arr2) -> arr1[0] - arr2[0]);
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            if (!queue.isEmpty() && queue.peek() < start) queue.poll();
            queue.add(end);
        }

        return queue.size();
    }
}
