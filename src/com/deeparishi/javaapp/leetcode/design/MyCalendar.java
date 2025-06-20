package com.deeparishi.javaapp.leetcode.design;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// https://leetcode.com/problems/my-calendar-i

public class MyCalendar {

    Set<int[]> bookings;
    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        this.bookings = new HashSet<>();
        this.map = new TreeMap<>();
    }

    public static void main(String[] args) {

        MyCalendar calendar1 = new MyCalendar();
        System.out.println(calendar1.book(10, 20));
        System.out.println(calendar1.book(15, 25));
        System.out.println(calendar1.book(20, 30));

        System.out.println();

        MyCalendar calendar2 = new MyCalendar();
        System.out.println(calendar2.book(47, 50));
        System.out.println(calendar2.book(33, 41));
        System.out.println(calendar2.book(39, 45));
        System.out.println(calendar2.book(33, 42));
        System.out.println(calendar2.book(25, 32));
        System.out.println(calendar2.book(26, 35));
        System.out.println(calendar2.book(19, 25));
        System.out.println(calendar2.book(3, 8));
        System.out.println(calendar2.book(8, 13));
        System.out.println(calendar2.book(18, 27));

    }

    // Brute Force Approach
    public boolean bookV1(int startTime, int endTime) {

        for (int[] booking : bookings) {
            int st = booking[0];
            int end = booking[1];
            if (startTime < end && endTime > st) return false;
        }

        bookings.add(new int[]{startTime, endTime});
        return true;
    }

    // Better Approach
    public boolean bookV2(int startTime, int endTime) {

        Integer prev = map.floorKey(startTime); // Closest booking ending before or at startTime
        Integer next = map.ceilingKey(startTime); // Closest booking starting after or at startTime

        if (prev != null && map.get(prev) > startTime)
            return false; // Overlaps with the previous booking

        if (next != null && next < endTime)
            return false; // Overlaps with the next booking

        map.put(startTime, endTime);
        return true;

    }

    // Optimal Approach
    public boolean book(int start, int end) {

        Map.Entry<Integer, Integer> entry = map.lowerEntry(end);

        if (entry != null && entry.getValue() > start)
            return false;

        map.put(start, end);
        return true;
    }
}