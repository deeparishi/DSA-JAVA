package com.deeparishi.javaapp.leetcode.graph.stronglyconnectedcomponents;

// https://www.youtube.com/watch?v=R6uoSjZ2imo&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=54
// https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1

import java.util.*;

public class StronglyConnectedComponents {

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(Arrays.asList(2, 3));
        adj.add(List.of(0));
        adj.add(List.of(1));
        adj.add(List.of(4));
        adj.add(Collections.emptyList());

        System.out.println(findStronglyConnectedComponents(adj));
    }

    public static int findStronglyConnectedComponents(List<List<Integer>> adj) {

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i])
                dfs(adj, visited, stack, i);
        }


        List<List<Integer>> transposedGraph = transposeGraph(adj);
        Arrays.fill(visited, false);

        int count = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                count++;
                dfs(transposedGraph, visited, new Stack<>(), node);
            }
        }

        return count;
    }

    private static List<List<Integer>> transposeGraph(List<List<Integer>> adj) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.size(); i++) {
            for (Integer neighbour : adj.get(i))
                graph.get(neighbour).add(i);
        }

        return graph;
    }

    private static void dfs(List<List<Integer>> adj, boolean[] visited,
                            Stack<Integer> stack, Integer node) {

        visited[node] = true;
        for (Integer neighbour : adj.get(node)) {
            if (!visited[neighbour])
                dfs(adj, visited, stack, neighbour);
        }

        stack.push(node);
    }

}
