package com.deeparishi.javaapp.leetcode.graph.dfs;

import java.util.Arrays;

//https://leetcode.com/problems/is-graph-bipartite/

public class IsBipartite {

    public static void main(String[] args) {

    }

    public static boolean isBipartiteUsingDFS(int[][] graph) {

        int[] color = new int[graph.length];
        Arrays.fill(color, -1);

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1)
                if (dfs(i, 0, color, graph)) return false;
        }

        return true;
    }

    private static boolean dfs(int node, int col, int[] color, int[][] graph) {

        color[node] = col;

        for (int it : graph[node]) {
            if (color[it] == -1) {
                if (dfs(it, 1 - col, color, graph))
                    return true;
            } else if (color[it] == col)
                return true;
        }

        return false;
    }
}
