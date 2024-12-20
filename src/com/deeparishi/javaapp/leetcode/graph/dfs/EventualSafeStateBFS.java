package com.deeparishi.javaapp.leetcode.graph.dfs;

//https://leetcode.com/problems/find-eventual-safe-states/

import java.util.ArrayList;
import java.util.List;

public class EventualSafeStateBFS {

    public static void main(String[] args) {
        int[][] graph = {
                {1},
                {2},
                {3},
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

        int row = graph.length;
        boolean[] visited = new boolean[row];
        boolean[] pathVisited = new boolean[row];
        int[] checkmate = new int[row];

        for (int i = 0; i < row; i++) {
            if(!visited[i])
                dfs(i, visited, pathVisited, checkmate, graph);
        }

        List<Integer> safeNodes =  new ArrayList<>();

        for (int i = 0; i < row; i++) {
            if(checkmate[i] == 1)
                safeNodes.add(i);
        }

        return safeNodes;
    }

    private static boolean dfs(int val, boolean[] visited, boolean[] pathVisited,
                               int[] checkmate, int[][] graph) {

        visited[val] = true;
        pathVisited[val] = true;

        for (int neighbour : graph[val]) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, visited, pathVisited, checkmate, graph))
                    return true;
            } else if (pathVisited[neighbour]) {
                return true;
            }
        }

        checkmate[val] = 1;
        pathVisited[val] = false;
        return false;
    }

}
