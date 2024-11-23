package com.deeparishi.javaapp.leetcode.graph;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1?page=3&category=Algorithms&sortBy=submissions

public class DFS {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 5;

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(1).add(4);
        adj.get(2).add(0);
        adj.get(3).add(1);
        adj.get(4).add(1);


        ArrayList<Integer> dfsResult = dfsOfGraph(adj);
        System.out.println("DFS Traversal of the graph: " + dfsResult);
    }

    public static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[adj.size() + 1];
        visited[0] = true;
        ArrayList<Integer> res = new ArrayList<>();
        dfsOfGraph(0, visited, res, adj);

        return res;
    }

    private static void dfsOfGraph(int node, boolean[] visited,
                                   ArrayList<Integer> res, ArrayList<ArrayList<Integer>> adj) {

        visited[node] = true;
        res.add(node);

        for (Integer v : adj.get(node)) {
            if (!visited[v]) {
                dfsOfGraph(v, visited, res, adj);
            }
        }
    }
}