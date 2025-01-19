package com.deeparishi.javaapp.leetcode.greedyalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingRoom {

    public static void main(String[] args) {

        int[] start = {0, 3, 1, 5, 5, 8};
        int[] end = {5, 4, 2, 9, 7, 9};

        maximizeBooking(start, end);
    }

    public static void maximizeBooking(int[] start, int[] end) {

        Meeting[] meetings = new Meeting[start.length];

        for (int i = 0; i < start.length; i++) {
            Meeting meeting = new Meeting(start[i], end[i], i + 1);
            meetings[i] = meeting;
        }

        Arrays.sort(meetings, (o1, o2) -> o1.endTime - o2.endTime);

        int count = 1;
        int freeTIme = meetings[0].endTime;
        List<Integer> pos = new ArrayList<>();
        pos.add(meetings[0].pos);

        for (int i = 1; i < start.length; i++) {
            if (meetings[i].startTime > freeTIme) {
                count++;
                freeTIme = meetings[i].endTime;
                pos.add(meetings[i].pos);
            }
        }

        System.out.println("Maximum print room : " + count);
        System.out.println("Positions : " + pos);
    }
}

class Meeting {

    public Meeting(int startTime, int endTime, int pos) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.pos = pos;
    }

    int startTime;

    int endTime;

    int pos;
}
