package com.deeparishi.javaapp.leetcode.graph;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1?page=2&category=Algorithms&sortBy=submissions
public class BFS {

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


        ArrayList<Integer> bfsResult = bfsOfGraph(V, adj);
        System.out.println("BFS Traversal of the graph: " + bfsResult);

    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];
        ArrayList<Integer> bfs = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()){
            Integer polled = queue.poll();
            bfs.add(polled);

            for(int node : adj.get(polled)){
                if(!visited[node]){
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }

        return bfs;

    }
}
