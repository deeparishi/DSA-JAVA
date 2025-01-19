package com.deeparishi.javaapp.leetcode.graph.disjointset;

import com.deeparishi.javaapp.leetcode.graph.disjointset.utils.DisjointSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/redundant-connection/?envType=problem-list-v2&envId=graph

public class FindRedundantConnection {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {1, 2},
                {1, 3},
                {2, 3}
        };

        int[] result = findRedundantConnection(edges);
        System.out.println(Arrays.toString(result));
    }

    public static int[] findRedundantConnection(int[][] edges) {

        int len = edges.length;
        DisjointSet ds = new DisjointSet(len + 1);

        for (int[] edge : edges){
            if(!ds.unionBySizeWithReturnType(edge[0], edge[1]))
                return edge;
        }

        return new int[]{0};
    }

    public static int[] findRedundantConnectionDFS(int[][] edges) {

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

    private static boolean dfs(List<List<Integer>> graph, int u, int v, boolean[] visited) {

        if (u == v)
            return true;

        visited[u] = true;

        for (Integer neighbour : graph.get(v)) {
            if (!visited[neighbour]) {
                if (dfs(graph, neighbour, v, visited))
                    return true;
            }
        }

        return false;
    }
}
