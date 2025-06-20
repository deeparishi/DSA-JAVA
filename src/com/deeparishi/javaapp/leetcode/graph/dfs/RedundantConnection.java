package com.deeparishi.javaapp.leetcode.graph.dfs;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/redundant-connection

public class RedundantConnection {

    public static void main(String[] args) {

    }

    public int[] findRedundantConnection(int[][] edges) {

        int len = edges.length;
        ;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= len; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            boolean[] visited = new boolean[edges.length + 1];
            if (dfs(graph, u, v, visited)) {
                return edge;
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return new int[]{0};
    }

    private boolean dfs(List<List<Integer>> graph, int u, int v, boolean[] visited) {

        if (u == v)
            return true;

        visited[u] = true;

        for (Integer neighbour : graph.get(u)) {
            if (!visited[neighbour]) {
                if (dfs(graph, neighbour, v, visited))
                    return true;
            }
        }

        return false;
    }
}
