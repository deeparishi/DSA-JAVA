package com.deeparishi.javaapp.leetcode.graph.topologicalsort;

import java.util.*;

//https://leetcode.com/problems/find-eventual-safe-states/

public class EventualSafeStateTopoSort {

    public static void main(String[] args) {
        int[][] graph = {
                {1},
                {2},
                {3, 4},
                {4, 5},
                {6},
                {6},
                {7},
                {},
                {1, 9},
                {10},
                {8},
                {9}
        };

        System.out.println(eventualSafeNodes(graph));
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        List<List<Integer>> revAdj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            revAdj.add(new ArrayList<>());
        }

        int[] inDegree = new int[n];
        for (int owner = 0; owner < n; owner++) {
            for(int neighbour : graph[owner]){
                revAdj.get(neighbour).add(owner);
                inDegree[owner]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(inDegree[i] == 0)
                queue.add(i);
        }

        List<Integer> safeNodes = new ArrayList<>();

        while (!queue.isEmpty()){
            int node = queue.poll();
            safeNodes.add(node);

            for (int neighbour : revAdj.get(node)){
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0)
                    queue.add(neighbour);
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }

}