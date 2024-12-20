package com.deeparishi.javaapp.leetcode.graph.shortestpath.dijikistra;

//https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination {

    public static void main(String[] args) {
        // {src, destination, distance}
        int[][] roads = new int[][]{
                {0, 6, 7},
                {0, 1, 2},
                {1, 2, 3},
                {1, 3, 3},
                {6, 3, 3},
                {3, 5, 1},
                {6, 5, 1},
                {2, 5, 1},
                {0, 4, 5},
                {4, 6, 2}
        };

        System.out.println(countPaths(7, roads));

    }

    public static int countPaths(int n, int[][] roads) {

        List<List<Pair>> pairs = new ArrayList<>();

        for (int i = 0; i < n; i++)
            pairs.add(new ArrayList<>());


        for (int[] road : roads) {
            pairs.get(road[0]).add(new Pair(road[1], road[2]));
            pairs.get(road[1]).add(new Pair(road[0], road[2]));
        }

        long[] distance = new long[n];
        int[] ways = new int[n];

        Arrays.fill(distance, Long.MAX_VALUE);
        Arrays.fill(ways, 0);

        distance[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> Long.compare(a.distance, b.distance));

        queue.add(new Pair(0, 0));
//        int mod = (int) (1e9 + 7);

        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            long dist = pair.distance;
            int node = pair.node;

            for (Pair neighbour : pairs.get(node)){
                int adjNode = neighbour.node;
                long adjDist = neighbour.distance;
                if(adjDist + dist < distance[adjNode]){
                    distance[adjNode] = adjDist + dist;
                    ways[adjNode] = ways[node];
                    queue.add(new Pair(adjNode, adjDist + dist));
                }else if(adjDist + dist == distance[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node]);
//                    % mod;
                }
            }
        }

        return ways[n - 1];
//        % mod;
    }
}

class Pair{

    public Pair(int node, long distance) {
        this.distance = distance;
        this.node = node;
    }

    long distance;

    int node;
}

/*
              {node, distance}
         0 -> {6, 7}, {1, 2}, {4, 5}
         1 -> {0, 2}, {2, 3}, {3, 3}
         2 -> {5, 1}, {1, 3}
         3 -> {1, 3}, {5, 1}, {6, 3}
         4 -> {0, 5}, {6, 2}
         5 -> {2, 1}, {3, 1}, {6, 1}
         6 -> {0, 7}, {3, 3}, {5, 1}, {4, 2}
 */