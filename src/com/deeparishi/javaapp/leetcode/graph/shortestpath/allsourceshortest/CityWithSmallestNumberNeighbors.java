package com.deeparishi.javaapp.leetcode.graph.shortestpath.allsourceshortest;

// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

public class CityWithSmallestNumberNeighbors {

    public static void main(String[] args) {

    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {


        int[][] vertices = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vertices[i][j] = (i == j) ? 0 : Integer.MAX_VALUE; // Distance to self is 0
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            vertices[u][v] = wt;
            vertices[v][u] = wt;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (vertices[i][k] != Integer.MAX_VALUE && vertices[k][j] != Integer.MAX_VALUE) {
                        vertices[i][j] = Math.min(vertices[i][j], vertices[i][k] + vertices[k][j]);
                    }
                }
            }
        }

        int cntCity = n;
        int city = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (vertices[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            if (count <= cntCity) {
                cntCity = count;
                city = i;
            }
        }

        return city;
    }
}
