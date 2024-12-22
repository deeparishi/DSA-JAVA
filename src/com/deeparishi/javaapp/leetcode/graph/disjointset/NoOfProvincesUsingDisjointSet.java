package com.deeparishi.javaapp.leetcode.graph.disjointset;

import com.deeparishi.javaapp.leetcode.graph.disjointset.utils.DisjointSet;

// https://leetcode.com/problems/number-of-provinces/

public class NoOfProvincesUsingDisjointSet {

    public static void main(String[] args) {

        int[][] graphMatrix = new int[][] {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        System.out.println(findCircleNum(graphMatrix));

    }

    public static int findCircleNum(int[][] isConnected) {

        int len = isConnected.length;
        DisjointSet ds = new DisjointSet(len);

        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                if (isConnected[row][col] == 1)
                    ds.union(row, col);
            }
        }

        int count = 0;

        for (int i = 0; i < len; i++) {
            if (ds.find(i) == i)
                count++;
        }

        return count;
    }
}