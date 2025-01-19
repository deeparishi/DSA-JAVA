package com.deeparishi.javaapp.leetcode.graph.shortestpath.dijikistra;

import java.util.*;

// https://leetcode.com/problems/path-with-maximum-probability/?envType=problem-list-v2&envId=graph

public class PathWithMaxProb {

    public static void main(String[] args) {

        int[][] edges = new int[][]{
                {0, 1},
                {1, 2},
                {0, 2}
        };

        double[] suchProb = new double[]{0.5, 0.5, 0.2};

        System.out.println(maxProbability(3, edges, suchProb, 0, 2));
    }

    public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        Map<Integer, List<Pair>> graph = new HashMap<>();
        int idx = 0;

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            double prob = succProb[idx++];

            graph.putIfAbsent(from, new ArrayList<>());
            graph.putIfAbsent(to, new ArrayList<>());

            graph.get(from).add(new Pair(to, prob));
            graph.get(to).add(new Pair(from, prob));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probability, a.probability));
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;

        pq.offer(new Pair(start, 1.0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int currentNode = current.node;
            double currentProb = current.probability;

            if (currentNode == end) return currentProb;
            if (currentProb < maxProb[currentNode]) continue;
            if (!graph.containsKey(currentNode)) continue;

            for (Pair neighbor : graph.get(currentNode)) {
                double newProb = currentProb * neighbor.probability;
                if (newProb > maxProb[neighbor.node]) {
                    maxProb[neighbor.node] = newProb;
                    pq.offer(new Pair(neighbor.node, newProb));
                }
            }
        }

        return 0.0;
    }

    static class Pair {
        int node;
        double probability;

        Pair(int node, double probability) {
            this.node = node;
            this.probability = probability;
        }
    }
}