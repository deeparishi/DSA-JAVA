package com.deeparishi.javaapp.leetcode.graph;

//https://www.geeksforgeeks.org/problems/number-of-provinces/1?page=1&category=Graph&sortBy=submissions

import java.util.ArrayList;
import java.util.stream.IntStream;

public class NoOfProvinces {
    public static void main(String[] args) {


    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<>());

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int[] visit = new int[V];
        int cnt = 0;

        for (int i = 0; i < V; i++) {
            if(visit[i] == 0){
                cnt++;
                dfs(i, adjList, visit);
            }
        }
        return cnt;
    }

    private static void dfs(int i, ArrayList<ArrayList<Integer>> adjList,
                            int[] visit) {

        visit[i] = 1;

        for (Integer a : adjList.get(i))
            if(visit[i] == 0)
                dfs(a, adjList, visit);

    }

}
