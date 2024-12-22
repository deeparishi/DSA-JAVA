package com.deeparishi.javaapp.leetcode.graph.disjointset;


import com.deeparishi.javaapp.leetcode.graph.disjointset.utils.DisjointSet;

// https://leetcode.com/problems/number-of-operations-to-make-network-connected/

public class NoOfOperationToMakeNetWorkConnected {

    public static void main(String[] args) {

    }

    public static int makeConnected(int n, int[][] connections) {

        if (connections.length < n - 1)
            return -1;


        DisjointSet ds = new DisjointSet(n);
        int extraCount = 0;

        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            if (ds.find(u) == ds.find(v)) {
                extraCount++;
            } else {
                ds.union(u, v);
            }
        }

        int components = ds.countComponents();
        int edgesNeeded = components - 1;

        return extraCount >= edgesNeeded ? edgesNeeded : -1;
    }
}
