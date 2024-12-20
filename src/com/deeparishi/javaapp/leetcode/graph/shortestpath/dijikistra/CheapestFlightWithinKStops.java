package com.deeparishi.javaapp.leetcode.graph.shortestpath.dijikistra;

import java.util.*;

//https://leetcode.com/problems/cheapest-flights-within-k-stops/submissions/1480813798/

public class CheapestFlightWithinKStops {

    public static void main(String[] args) {
//        int[][] flights = new int[][]{
//                {0, 1, 100},
//                {1, 2, 100},
//                {2, 0, 100},
//                {1, 3, 600},
//                {2, 3, 200}
//        };


        int[][] flights = new int[][]{
                {1, 0, 5}
        };

        System.out.println(findCheapestPrice(2, flights, 0, 1, 1));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pairs>> pairs = new ArrayList<>();

        for (int i = 0; i < n; i++)
            pairs.add(new ArrayList<>());

        for (int[] flight : flights)
            pairs.get(flight[0]).add(new Pairs(flight[1], flight[2]));

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        Queue<Tuples> queue = new LinkedList<>();
        queue.add(new Tuples(0, src, 0));

        while (!queue.isEmpty()) {

            Tuples tuple = queue.poll();
            int stops = tuple.stops;
            int node = tuple.node;
            int cost = tuple.cost;

            if (stops > k)
                continue;

            for (Pairs neighbour : pairs.get(node)) {
                int adjNode = neighbour.first;
                int adjCost = neighbour.second;
                if (cost + adjCost < distance[adjNode]) {
                    distance[adjNode] = cost + adjCost;
                    queue.add(new Tuples(stops + 1, adjNode, cost + adjCost));
                }
            }
        }

        if (distance[dst] == Integer.MAX_VALUE) return -1;

        return distance[dst];

    }
}

class Pairs{

    int first;

    int second;

    public Pairs(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Tuples{

    int stops;

    int node;

    int cost;

    public Tuples(int stops,int node, int cost){
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}