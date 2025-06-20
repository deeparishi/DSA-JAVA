package com.deeparishi.javaapp.leetcode.graph.topologicalsort;

// https://leetcode.com/problems/remove-methods-from-project/description/?envType=problem-list-v2&envId=breadth-first-search

import java.util.*;

public class RemoveMethodFromProject {

    public static void main(String[] args) {

    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, List<Integer>> reverseGraph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
            reverseGraph.put(i, new ArrayList<>());
        }

        for (int[] invocation : invocations) {
            int from = invocation[0];
            int to = invocation[1];
            graph.get(from).add(to);
            reverseGraph.get(to).add(from);
        }

        // Step 2: Use BFS to mark all suspicious methods
        Set<Integer> suspiciousMethods = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        suspiciousMethods.add(k);

        while (!queue.isEmpty()) {
            int method = queue.poll();
            for (int next : graph.get(method)) {
                if (!suspiciousMethods.contains(next)) {
                    suspiciousMethods.add(next);
                    queue.add(next);
                }
            }
        }

        // Step 3: Check if we can remove all suspicious methods
        for (int method : suspiciousMethods) {
            for (int invoker : reverseGraph.get(method)) {
                if (!suspiciousMethods.contains(invoker)) {
                    // If a non-suspicious method invokes a suspicious one, removal is impossible
                    return getAllMethods(n);
                }
            }
        }

        // Step 4: Return non-suspicious methods
        List<Integer> remaining = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspiciousMethods.contains(i)) {
                remaining.add(i);
            }
        }
        return remaining;
    }

    private static List<Integer> getAllMethods(int n) {
        List<Integer> allMethods = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            allMethods.add(i);
        }
        return allMethods;
    }

}