package com.deeparishi.javaapp.leetcode.graph.shortestpath.basic;

//https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1

import java.util.*;

public class ShortestPathInUndirectedGraph {

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {0, 3},
                {3, 4},
                {4, 5},
                {5, 6},
                {1, 2},
                {2, 6},
                {6, 7},
                {7, 8},
                {6, 8}
        };

        int n = 9;
        int src = 0;

        System.out.println(Arrays.toString(shortestPathPractice(edges, n, 10, src)));
    }


    public static int[] shortestPath(int[][] edges, int len, int m, int src) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < len; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        int[] dist = new int[len];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!queue.isEmpty()) {
            int polled = queue.poll();

            for (Integer neighbour : adj.get(polled)) {
                if (dist[polled] + 1 < dist[neighbour]) {
                    dist[neighbour] = dist[polled] + 1;
                    queue.add(neighbour);
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;

    }

    public static int[] shortestPathPractice(int[][] edges, int len, int m, int src) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < len; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] minDistance = new int[len];
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        minDistance[src] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int owner = queue.poll();

            for (int neighbour : adj.get(owner)) {
                if (minDistance[owner] + 1 < minDistance[neighbour]) {
                    minDistance[neighbour] = minDistance[owner] + 1;
                    queue.add(neighbour);
                }
            }
        }

        return minDistance;
    }

}