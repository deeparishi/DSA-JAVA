package com.deeparishi.javaapp.leetcode.graph.dfs;

// https://leetcode.com/problems/critical-connections-in-a-network/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInNetwork {

    private static int timer = 1;

    public static void main(String[] args) {

        List<List<Integer>> connections = new ArrayList<>();

        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(1, 4));
        connections.add(Arrays.asList(2, 3));
        connections.add(Arrays.asList(3, 4));
        connections.add(Arrays.asList(4, 5));
        connections.add(Arrays.asList(5, 6));
        connections.add(Arrays.asList(6, 7));
        connections.add(Arrays.asList(6, 9));
        connections.add(Arrays.asList(7, 8));
        connections.add(Arrays.asList(8, 9));
        connections.add(Arrays.asList(8, 10));
        connections.add(Arrays.asList(10, 11));
        connections.add(Arrays.asList(10, 12));
        connections.add(Arrays.asList(11, 12));

        System.out.println(criticalConnections(13, connections));
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {


        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> adj = buildGraph(connections, n);

        int[] low = new int[n];
        int[] tin = new int[n];
        boolean[] visited = new boolean[n];

        dfs(1, -1, adj, tin, low, visited, result);
        return result;
    }

    // Low - Lowest time of insertion (min steps to reach from parent of curr node)
    // tin - time of insertion (steps to reach from root)
    private static void dfs(int node, int parent, List<List<Integer>> adj,
                     int[] tin, int[] low, boolean[] visited,
                     List<List<Integer>> connections) {

        visited[node] = true;
        tin[node] = timer;
        low[node] = timer;
        timer++;

        for (Integer neighbour : adj.get(node)) {
            if (neighbour == parent) continue;
            if (!visited[neighbour]) {
                dfs(neighbour, node, adj, tin, low, visited, connections);
                low[node] = Math.min(low[node], low[neighbour]);
                // Neighbour's lowest time of insertion should be greater than parent's time of insertion then only it'll construct the bridge
                if (low[neighbour] > tin[node])
                    connections.add(Arrays.asList(neighbour, node));
            } else
                low[node] = Math.min(low[node], low[neighbour]);
        }

    }

    private static List<List<Integer>> buildGraph(List<List<Integer>> connections, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
}