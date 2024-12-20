package com.deeparishi.javaapp.leetcode.graph.shortestpath.dijikistra;

import java.util.*;

// https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1

/*
        W - Weight
        F - From
        T - To
 */

public class ShortestPathWeightedUndirectedGraph {

    public static void main(String[] args) {
        int n = 5, m = 6;
        int[][] edges = {
            //   F  T  W
                {1, 2, 2},
                {1, 3, 4},
                {2, 4, 7},
                {2, 5, 1},
                {3, 5, 3},
                {4, 5, 2}
        };

        System.out.println(shortestPath(n, m, edges));
    }

    public static List<Integer> shortestPath(int n, int m, int[][] edges) {

        List<List<Path>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Path(edge[1], edge[2]));
            adj.get(edge[1]).add(new Path(edge[0], edge[2]));
        }

        PriorityQueue<Path> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        dist[1] = 0;
        parent[1] = 1;
        pq.add(new Path(1, 0));

        while (!pq.isEmpty()) {

            Path current = pq.poll();
            int u = current.dest;
            int d = current.distance;

            if (d > dist[u]) continue;

            for (Path neighbor : adj.get(u)) {
                int v = neighbor.dest;
                int weight = neighbor.distance;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    parent[v] = u;
                    pq.add(new Path(v, dist[v]));
                }
            }
        }

        if (dist[n] == Integer.MAX_VALUE)
            return Collections.singletonList(-1);

        List<Integer> path = new ArrayList<>();
        int node = n;

        while (node != parent[node]) {
            path.add(node);
            node = parent[node];
        }

        path.add(1);
        Collections.reverse(path);
        path.addFirst(dist[n]);

        return path;
    }
}

class Path {
    int dest, distance;

    public Path(int dest, int distance) {
        this.dest = dest;
        this.distance = distance;
    }
}