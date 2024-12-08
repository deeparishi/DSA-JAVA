package com.deeparishi.javaapp.leetcode.graph.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/course-schedule/description/

public class CourseScheduler {

    public static void main(String[] args) {

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[0]).add(prerequisite[1]);
        }

        int[] incomingEdges = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for (int neighbour : prerequisites[i])
                incomingEdges[neighbour]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < incomingEdges.length; i++) {
            if(incomingEdges[i] == 0)
                queue.add(i);
        }

        int count = 0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            count++;

            for (Integer neighbour : prerequisites[node]){
                incomingEdges[neighbour]--;
                if(incomingEdges[neighbour] == 0)
                    queue.add(neighbour);
            }
        }

        return count == numCourses;
    }

    public static boolean canFinishOptimized(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            adj.get(prereq).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int processedCourses = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            processedCourses++;

            for (int neighbor : adj.get(current)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return processedCourses == numCourses;
    }

}
