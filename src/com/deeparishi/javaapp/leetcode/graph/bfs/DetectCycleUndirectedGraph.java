package com.deeparishi.javaapp.leetcode.graph.bfs;

//https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?page=1&category=Graph&sortBy=submissions


import com.deeparishi.javaapp.leetcode.graph.utls.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleUndirectedGraph {

    public static void main(String[] args) {

        int vertices = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        adj.get(0).add(0);
        adj.get(1).add(2);
        adj.get(1).add(4);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(1);
        adj.get(4).add(3);

        System.out.println(isCycle(adj));
    }

    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[adj.size()];

        // Using BFS Technique
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                if (bfs(i, adj, visited))
                    return true;
            }
        }

        // Using DFS Technique
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                if (dfs(i, -1, adj, visited))
                    return true;
            }
        }

        return false;
    }

    private static boolean bfs(int source, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[source] = true;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(source, -1));

        while (!queue.isEmpty()) {

            int currValue = queue.peek().first;
            int parentValue = queue.peek().second;

            queue.poll();

            for (Integer adjValue : adj.get(currValue)) {
                if (!visited[adjValue]) {
                    visited[adjValue] = true;
                    queue.add(new Pair(adjValue, currValue));
                } else if (adjValue != parentValue)
                    return true;
            }
        }

        return false;
    }


    private static boolean dfs(int source, int parent,
                               ArrayList<ArrayList<Integer>> adj, boolean[] visited) {

        visited[source] = true;

        for (int adjValue : adj.get(source)) {
            if (!visited[adjValue]) {
                if (dfs(adjValue, source, adj, visited))
                    return true;
            } else if (adjValue != parent)
                return true;

        }

        return false;
    }
}