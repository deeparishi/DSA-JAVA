package com.deeparishi.javaapp.dsaconcepts.graph.minimumspantree;

import com.deeparishi.javaapp.dsaconcepts.graph.minimumspantree.utls.Pairs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1

public class PrimsAlgorithm {

    public static void main(String[] args) {

    }

    static int calculateWeightOfMinimumEdges(List<List<List<Integer>>> graph){

        PriorityQueue<Pairs> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Pairs(0, 0));

        boolean[] visited = new boolean[graph.size()];
        int sum = 0;

        while (!pq.isEmpty()){

            Pairs pair = pq.poll();
            int node = pair.node;
            int weight = pair.weight;

            if(visited[node]) continue;

            visited[node] = true;
            sum += weight;

            for (int i = 0; i < graph.get(node).size(); i++) {
                int adjWt = graph.get(node).get(i).get(1);
                int adjNode = graph.get(node).get(i).get(0);
                if(visited[adjNode])
                    pq.add(new Pairs(adjWt, adjNode));
            }

        }

        return sum;
    }



    static int spanningTree(int V, int E, List<List<int[]>> adj) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0});

        boolean[] visited = new boolean[V];
        int sum = 0;

        while (!pq.isEmpty()) {

            int[] edge = pq.poll();
            int node = edge[0];
            int weight = edge[1];

            if (visited[node]) continue;

            visited[node] = true;
            sum += weight;

            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int adjWeight = neighbor[1];
                if (!visited[adjNode]) {
                    pq.add(new int[]{adjNode, adjWeight});
                }
            }
        }

        return sum;
    }

    static List<List<int[]>> minSpanningTree(int V, List<List<int[]>> adj){

        List<List<int[]>> res = new ArrayList<>();

        return res;
     }
}
