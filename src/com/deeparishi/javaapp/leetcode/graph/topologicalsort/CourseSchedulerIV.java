package com.deeparishi.javaapp.leetcode.graph.topologicalsort;

import java.util.*;

//https://leetcode.com/problems/course-schedule-iv/?envType=problem-list-v2&envId=topological-sort

public class CourseSchedulerIV {

    public static void main(String[] args) {

        int numCourses = 3;

        int[][] prerequisites = {
                {1, 2},
                {1, 0},
                {2, 0}
        };

        int[][] queries = {
                {1, 0},
                {1, 2}
        };

        System.out.println(checkIfPrerequisite(numCourses, prerequisites, queries));

    }

    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites,
                                             int[][] queries) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        for (int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
            inDegree[pre[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);
            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        Set<Integer>[] reachable = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            reachable[i] = new HashSet<>();
        }

        for (int node : topoOrder) {
            for (int neighbor : graph.get(node)) {
                reachable[neighbor].addAll(reachable[node]);
                reachable[neighbor].add(node);
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(reachable[query[1]].contains(query[0]));
        }

        return result;

    }
}
