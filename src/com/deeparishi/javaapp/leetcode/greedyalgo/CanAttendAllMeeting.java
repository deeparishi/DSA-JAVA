package com.deeparishi.javaapp.leetcode.greedyalgo;

import java.util.Arrays;

// https://1nv1n.github.io/ProgrammingFundamentals/Practice/LeetCode/MeetingRooms/

public class CanAttendAllMeeting {

    public static void main(String[] args) {

        int[][] a = {
                {0, 30},
                {5, 10},
                {15, 20}
        };

        System.out.println(canAttendAllMeeting(a));

        int[][] b = {
                {7, 10},
                {2, 4},
        };

        System.out.println(canAttendAllMeeting(b));
    }

    public static boolean canAttendAllMeeting(int[][] meetings) {

        Arrays.sort(meetings, (arr1, arr2) -> arr1[0] - arr2[0]);

        for (int i = 1; i < meetings.length; i++) {
            int prevEnd = meetings[i - 1][1];
            int start = meetings[i][0];
            if (start < prevEnd)
                return false;
        }

        return true;
    }
}
