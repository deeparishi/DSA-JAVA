package com.deeparishi.javaapp.leetcode.graph.disjointset;

// https://leetcode.com/problems/possible-bipartition/description/?envType=problem-list-v2&envId=graph

import com.deeparishi.javaapp.leetcode.graph.disjointset.utils.DisjointSet;

public class PossibleBipartite {

    public static void main(String[] args) {

        int[][] dislikes1 = new int[][]{
                {1, 2},
                {1, 3},
                {2, 4}
        };

        int[][] dislikes2 = new int[][]{
                {1, 2},
                {1, 3},
                {2, 3}
        };

        System.out.println(possibleBipartition(4, dislikes1));
        System.out.println(possibleBipartition(3, dislikes2));

    }

    public static boolean possibleBipartition(int n, int[][] dislikes) {

        DisjointSet ds = new DisjointSet(2 * n + 1);

        for (int[] dislike : dislikes) {

            int u = dislike[0];
            int v = dislike[1];

            if (ds.find(u) == ds.find(v))
                return false;

            // Union a with b's opposite group and b with a's opposite group
            ds.union(u, v + n);
            ds.union(v, u + n);
        }

        return true;
    }
}
