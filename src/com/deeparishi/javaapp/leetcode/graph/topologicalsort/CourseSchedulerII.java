package com.deeparishi.javaapp.leetcode.graph.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/course-schedule-ii/

public class CourseSchedulerII {

    public static void main(String[] args) {

    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] incomingOrder = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preq = prerequisite[1];
            adj.get(preq).add(course);
            incomingOrder[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < adj.size(); i++) {
            if (incomingOrder[i] == 0)
                queue.add(i);
        }

        int[] topSort = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()){
            int node = queue.poll();
            topSort[index++] = node;

            for (Integer neighbour : adj.get(node)){
                incomingOrder[neighbour]--;
                if(incomingOrder[neighbour] == 0)
                    queue.add(neighbour);
            }
        }

        if (index != numCourses) {
            return new int[0];
        }

        return topSort;
    }

}
