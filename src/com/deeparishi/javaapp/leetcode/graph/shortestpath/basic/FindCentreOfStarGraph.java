package com.deeparishi.javaapp.leetcode.graph.shortestpath.basic;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/find-center-of-star-graph

public class FindCentreOfStarGraph {

    public static void main(String[] args) {

    }

    public static int findCenter(int[][] edges) {

        int res = edges.length * 2;
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            map.put(x, map.getOrDefault(x, 0) + 2);
            map.put(y, map.getOrDefault(y, 0) + 2);
        }

        for (Map.Entry<Integer, Integer> value : map.entrySet()) {
            int a = value.getKey();
            int b = value.getValue();
            if(b == res) return a;
        }

        return -1;
    }

    public int findCenterV2(int[][] edges) {

        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1])
            return edges[0][0];
        else if (edges[0][1] == edges[1][0] || edges[0][1] == edges[1][1])
            return edges[0][1];
        else
            return 0;
    }
}
