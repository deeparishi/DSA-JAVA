package com.deeparishi.javaapp.leetcode.graph.disjointset;

public class CoupleHoldingHands {

    public static void main(String[] args) {
        System.out.println(minSwapsCouples(new int[]{0, 2, 1, 3}));
    }

    public static int minSwapsCouples(int[] row) {
        int n = row.length / 2;
        UnionFind uf = new UnionFind(n);

        for (int i = 0; i < row.length; i += 2) {
            int firstPerson = row[i] / 2;
            int secondPerson = row[i + 1] / 2;
            uf.union(firstPerson, secondPerson);
        }

        int components = uf.countComponents();
        return n - components;

    }
}

class UnionFind {
    private final int[] parent;
    private final int[] rank;
    private int components;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        components = size;

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU != rootV) {
            if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
            components--;
        }
    }

    public int countComponents() {
        return components;
    }
}