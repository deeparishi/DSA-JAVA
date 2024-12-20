package com.deeparishi.javaapp.leetcode.graph.shortestpath.dijikistra;

import java.util.*;

// https://leetcode.com/problems/network-delay-time/submissions/1481702980/

public class NetworkDelayTime {

    public static void main(String[] args) {

        int[][] times = new int[][]{
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };

        System.out.println(networkDelayTimeUsingBellmanFord(times, 4, 2));

    }

    public static int networkDelayTimeUsingDijikistra(int[][] times, int n, int k) {

        List<List<NewPair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] time : times) {
            graph.get(time[0]).add(new NewPair(time[1], time[2]));
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        Queue<NewPair> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        queue.add(new NewPair(k, 0));

        while (!queue.isEmpty()) {
            NewPair current = queue.poll();
            int node = current.dest;
            int currWeight = current.weight;

            for (NewPair neighbor : graph.get(node)) {
                int adjNode = neighbor.dest;
                int edgeWeight = neighbor.weight;

                if (currWeight + edgeWeight < distance[adjNode]) {
                    distance[adjNode] = currWeight + edgeWeight;
                    queue.add(new NewPair(adjNode, distance[adjNode]));
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, distance[i]);
        }

        return max;
    }

    public static int networkDelayTimeUsingBellmanFord(int[][] times, int n, int k) {

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        for (int i = 1; i < n; i++) {
            for (int[] time : times) {
                int nodeSrc = time[0];
                int nodeDest = time[1];
                int nodeWeight = time[2];

                if (distance[nodeSrc] != Integer.MAX_VALUE && distance[nodeSrc] + nodeWeight < distance[nodeDest]) {
                    distance[nodeDest] = distance[nodeSrc] + nodeWeight;
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, distance[i]);
        }

        return max;
    }
}

class NewPair {

    public NewPair(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

    int dest;

    int weight;


}
