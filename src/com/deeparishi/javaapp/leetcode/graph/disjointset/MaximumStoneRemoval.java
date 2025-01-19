package com.deeparishi.javaapp.leetcode.graph.disjointset;

import com.deeparishi.javaapp.leetcode.graph.disjointset.utils.DisjointSet;

import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/problems/maximum-stone-removal-1662179442/1

public class MaximumStoneRemoval {

    public static void main(String[] args) {
        int[][] stones = new int[][]{
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 2},
                {2, 1},
                {2, 2},
        };
        System.out.println(maxRemove(stones, 6));
    }

    public static int maxRemove(int[][] stones, int n){

        int maxRow = 0;
        int maxCol = 0;

        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
        Map<Integer, Integer> stoneMap = new HashMap<>();

        for (int[] stone : stones) {
            int nodeRow = stone[0];
            int nodeCol = stone[1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            stoneMap.put(nodeRow, 1);
            stoneMap.put(nodeCol, 1);
        }

        int cnt = 0;
        for (Integer node : stoneMap.keySet())
            if (ds.find(node) == node)
                cnt++;


        return n - cnt;
    }
}
