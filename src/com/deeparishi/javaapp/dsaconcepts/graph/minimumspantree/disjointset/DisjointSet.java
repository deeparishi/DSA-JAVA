package com.deeparishi.javaapp.dsaconcepts.graph.minimumspantree.disjointset;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {

    private final List<Integer> rank;

    private final List<Integer> parent;

    private final List<Integer> size;

    public List<Integer> getParent() {
        return parent;
    }

    public DisjointSet(int size){
        rank = new ArrayList<>();
        parent = new ArrayList<>();
        this.size = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int find(int node) {

        if (parent.get(node) != node)
            parent.set(node, find(parent.get(node)));

        return parent.get(node);
    }

    public void union(int x, int y){

        int rootX = find(x);
        int rootY = find(y);

        if(rootX != rootY) {
            if (rank.get(rootX) > rank.get(rootY)) {
                parent.set(rootY, rootX);
            } else if (rank.get(rootX) < rank.get(rootY)) {
                parent.set(parent.get(rootX), rootY);
            } else {
                parent.set(rootY, rootX);
                rank.set(rootX, rank.get(rootX) + 1);
            }
        }
    }

    void unionBySize(int x, int y) {

        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (size.get(rootX) < size.get(rootY)) {
            parent.set(rootX, rootY);
            size.set(rootY, rootX);
        } else {
            parent.set(rootY, rootX);
            size.set(rootX, rootY);
        }

    }

    public int[] getNewPath(int x, int y){
        int[] path = new int[2];
        path[0] = parent.get(x);
        path[1] = parent.get(y);
        return path;
    }

    public boolean isConnected(int u, int v) {
        return find(u) == find(v);
    }
}
