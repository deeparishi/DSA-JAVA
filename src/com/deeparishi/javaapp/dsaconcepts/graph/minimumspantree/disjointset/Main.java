package com.deeparishi.javaapp.dsaconcepts.graph.minimumspantree.disjointset;

public class Main {
    public static void main(String[] args) {

//        DisjointSet ds = new DisjointSet(5);
//        ds.union(0, 1);
//        ds.union(1, 2);
//        ds.union(3, 4);
//        System.out.println("Are 0 and 4 connected? " + ds.isConnected(0, 4));
//        ds.union(2, 3);
//        System.out.println("Are 0 and 4 connected now? " + ds.isConnected(0, 4));

        DisjointSet set = new DisjointSet(7);
        set.union(1, 2);
        set.union(2, 3);
        set.union(4, 5);
        set.union(6, 7);
        System.out.println("Are 5 and 6 connected? " + set.isConnected(5, 6));
        set.union(5, 6);
        System.out.println("Are 3 and 7 connected? " + set.isConnected(3, 7));
        set.union(3, 7);
        System.out.println("Are 5 and 6 connected? " + set.isConnected(5, 6));
        System.out.println("Are 3 and 7 connected? " + set.isConnected(3, 7));
    }
}
