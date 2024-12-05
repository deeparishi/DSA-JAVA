package com.deeparishi.javaapp.leetcode.graph;


import java.util.ArrayList;

//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

public class DetectCycleInDirectedGraph {

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the graph
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0); // Cycle here
        adj.get(2).add(3);

        System.out.println(isCyclic(V, adj));
    }

    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!visited[i]) {
                if (dfs(i, visited, pathVisited, adj))
                    return true;
            }
        }

        return false;
    }

    private static boolean dfs(int val, boolean[] visited, boolean[] pathVisited, ArrayList<ArrayList<Integer>> adj) {

        visited[val] = true;
        pathVisited[val] = true;

        for(Integer neighbour : adj.get(val)){
            if(!visited[neighbour]){
                if(dfs(neighbour, visited, pathVisited, adj))
                    return true;
            } else if (pathVisited[neighbour]) {
                return true;
            }
        }

        pathVisited[val] = false;
        return false;
    }
}
