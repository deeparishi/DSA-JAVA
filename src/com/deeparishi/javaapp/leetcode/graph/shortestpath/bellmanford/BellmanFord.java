package com.deeparishi.javaapp.leetcode.graph.shortestpath.bellmanford;

import java.util.Arrays;

public class BellmanFord {

    public static void main(String[] args) {
        int[] res = bellmanFord(3, new int[][]{{0, 1, 9}}, 0);
        System.out.println(Arrays.toString(res));
    }

    static int[] bellmanFord(int v, int[][] edges, int src) {

        int[] distance = new int[v];
        Arrays.fill(distance, (int) 1e8);
        distance[src] = 0;

        for (int i = 0; i < v - 1; i++) {
            for (int[] edge : edges) {
                int nodeSrc = edge[0];
                int nodeDest = edge[1];
                int nodeWeight = edge[2];

                if (distance[nodeSrc] != (int) 1e8 && distance[nodeSrc] + nodeWeight < distance[nodeDest]) {
                    distance[nodeDest] = distance[nodeSrc] + nodeWeight;
                }
            }
        }

        for (int[] edge : edges) {
            int nodeSrc = edge[0];
            int nodeDest = edge[1];
            int nodeWeight = edge[2];

            if (distance[nodeSrc]  != (int) 1e8 && distance[nodeSrc] + nodeWeight < distance[nodeDest]) {
                return new int[]{-1};
            }
        }

        return distance;
    }

    static int[] bellmanFords(int v, int[][] edges, int src) {
        int[] distance = new int[v];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for (int i = 0; i < v - 1; i++) {
            for (int[] edge : edges) {
                int nodeSrc = edge[0];
                int nodeDest = edge[1];
                int nodeWeight = edge[2];

                if (distance[nodeSrc] != Integer.MAX_VALUE && distance[nodeSrc] + nodeWeight < distance[nodeDest]) {
                    distance[nodeDest] = distance[nodeSrc] + nodeWeight;
                }
            }
        }

        // Check for negative-weight cycles
        for (int[] edge : edges) {
            int nodeSrc = edge[0];
            int nodeDest = edge[1];
            int nodeWeight = edge[2];

            if (distance[nodeSrc] != Integer.MAX_VALUE && distance[nodeSrc] + nodeWeight < distance[nodeDest]) {
                return new int[]{-1}; // Negative-weight cycle found
            }
        }

        return distance;
    }
}