package com.deeparishi.javaapp.leetcode.graph.disjointset.utils;


public class DisjointSet {

    private final int[] parent;
    private final int[] rank;
    private final int[] size;

    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        this.size = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
            this.size[i] = 1;
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
            if (rank[rootU] > rank[rootV])
                parent[rootV] = rootU;
            else if (rank[rootU] < rank[rootV])
                parent[rootU] = rootV;
            else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }

    public void unionBySize(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (size[rootX] < size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }

    public boolean unionBySizeWithReturnType(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return false;

        if (size[rootX] < size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        } else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }

        return true;
    }

    public int countComponents() {
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (find(i) == i) {
                count++;
            }
        }
        return count;
    }

    public int getParent(int idx) {
        return parent[idx];
    }

    public int getRank(int idx) {
        return rank[idx];
    }

    public int getSize(int idx) {
        return size[idx];
    }

    public int[] getSize() {
        return size;
    }
}