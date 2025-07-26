package com.deeparishi.javaapp.leetcode.priorityqueue;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://leetcode.com/problems/task-scheduler/

public class TaskScheduler {

    public static void main(String[] args) {

        int i = leastIntervalOptimal(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);
        System.out.println(i);
    }

    public static int leastIntervalOptimal(char[] tasks, int n) {

        int[] freq = new int[26];
        for (char t : tasks) freq[t - 'A']++;

        Arrays.sort(freq);

        int maxFreq = freq[25];
        int max = 1;

        for (int i = 24; i >= 0; i--) {
            if (freq[i] != maxFreq) break;
            max++;
        }

        int slots = (maxFreq - 1) * (n + 1) + max;

        return Math.max(slots, tasks.length);
    }

    public static int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> freq = IntStream.range(0, tasks.length - 1)
                .mapToObj(i -> tasks[i])
                .collect(
                        Collectors.toMap(
                                c -> c,
                                c -> 1,
                                Integer::sum
                        )
                );

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.addAll(freq.values());

        Queue<int[]> cooldown = new LinkedList<>();
        int time = 0;

        while (!pq.isEmpty() || !cooldown.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                int remaining = pq.poll() - 1;
                if (remaining > 0) {
                    cooldown.add(new int[]{remaining, time + n});
                }
            }

            if (!cooldown.isEmpty() && cooldown.peek()[1] == time) {
                pq.offer(cooldown.poll()[0]);
            }
        }
        return time;
    }
}
