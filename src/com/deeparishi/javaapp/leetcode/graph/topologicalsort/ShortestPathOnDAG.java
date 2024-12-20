package com.deeparishi.javaapp.leetcode.graph.topologicalsort;

import com.deeparishi.javaapp.leetcode.graph.utls.Path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPathOnDAG {

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0, 1, 2},
                {0, 2, 1},
//                {1, 3, 1},
//                {2, 3, 3},
//                {3, 0, 0},
//                {4, 0, 3},
//                {4, 2, 1},
//                {5, 4, 1},
//                {6, 4, 2},
//                {6, 5, 3}
        };

        System.out.println(Arrays.toString(shortestPath(4, edges.length, edges)));
    }

    public static int[] shortestPath(int v, int e, int[][] edges) {
        ArrayList<ArrayList<Path>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int src = edges[i][0];
            int dest = edges[i][1];
            int weight = edges[i][2];
            adj.get(src).add(new Path(src, dest, weight));
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topoSort(i, stack, visited, adj);
            }
        }

        int[] minDistance = new int[v];
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        minDistance[0] = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (minDistance[node] != Integer.MAX_VALUE) {
                for (int i = 0; i < adj.get(node).size(); i++) {
                    int dest = adj.get(node).get(i).dest;
                    int weight = adj.get(node).get(i).weight;
                    if (minDistance[node] + weight < minDistance[dest]) {
                        minDistance[dest] = weight + minDistance[node];
                    }
                }
            }
        }

        for (int i = 0; i < minDistance.length; i++) {
            if (minDistance[i] == Integer.MAX_VALUE)
                minDistance[i] = -1;
        }

        return minDistance;
    }

    private static void topoSort(int path, Stack<Integer> stack,
                                 boolean[] visited, ArrayList<ArrayList<Path>> adj) {
        visited[path] = true;

        for (int i = 0; i < adj.get(path).size(); i++) {
            int v = adj.get(path).get(i).dest;
            if (!visited[v]) {
                topoSort(v, stack, visited, adj);
            }
        }

        stack.add(path);
    }
}