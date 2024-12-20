package com.deeparishi.javaapp.leetcode.graph.shortestpath.dijikistra;

import java.util.*;

//https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1


public class DijkistraAlgorithm {

    public static void main(String[] args) {

    }

    static ArrayList<Integer> dijkstraUsingQueue(ArrayList<ArrayList<iPair>> adj, int src) {

        PriorityQueue<iPair> queue = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);

        int[] dist = new int[adj.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        queue.add(new iPair(src, 0));

        while (!queue.isEmpty()) {
            iPair polled = queue.poll();

            int node = polled.destination;
            int distance = polled.distance;

            for (int i = 0; i < adj.get(node).size(); i++) {

                int edgeWeight = adj.get(node).get(i).distance;
                int adjNode = adj.get(node).get(i).destination;

                if (distance + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = distance + edgeWeight;
                    queue.add(new iPair(adjNode, dist[adjNode]));
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int j : dist)
            res.add(j);

        return res;
    }

    static ArrayList<Integer> dijkstraUsingSetDS(ArrayList<ArrayList<iPair>> adj, int src) {

        Set<iPair> set = new HashSet<>();

        int[] distance = new int[adj.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        set.add(new iPair(src, 0));

        while (!set.isEmpty()) {
            iPair polled = set.stream().min(Comparator.comparingInt(pair -> pair.distance)).get();
            set.remove(polled);

            int destination = polled.destination;
            int dist = polled.distance;

            for (iPair neighbor : adj.get(destination)) {
                int edgeWeight = neighbor.distance;
                int adjNode = neighbor.destination;

                if (dist + edgeWeight < distance[adjNode]) {
                    set.remove(new iPair(adjNode, distance[adjNode]));
                    distance[adjNode] = dist + edgeWeight;
                    set.add(new iPair(adjNode, distance[adjNode]));
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (Integer s : distance)
            res.add(s);

        return res;
    }
}

class iPair {

    int destination, distance;


    iPair(int first, int second) {
        this.destination = first;
        this.distance = second;
    }
}