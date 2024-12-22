package com.deeparishi.javaapp.dsaconcepts.graph.minimumspantree;

import com.deeparishi.javaapp.dsaconcepts.graph.minimumspantree.disjointset.DisjointSet;
import com.deeparishi.javaapp.dsaconcepts.graph.minimumspantree.utls.Edge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithm {

    public static void main(String[] args) {

        List<List<int[]>> adj = new ArrayList<>();
        adj.add(Arrays.asList(
                new int[]{2, 6, 7},
                new int[]{6, 3, 8},
                new int[]{4, 3, 5},
                new int[]{4, 2, 3},
                new int[]{1, 4, 1},
                new int[]{2, 3, 3},
                new int[]{1, 2, 2},
                new int[]{1, 5, 4}
        ));

        System.out.println(spanningTree(6, 6, adj));
    }

    static int spanningTree(int V, int E, List<List<int[]>> adj) {

//        for (int i = 0; i < adj.size(); i++) {
//            for (int j = 0; j < adj.get(i).size(); j++) {
//                int src = adj.get(i).get(j)[0];
//                int dest = adj.get(i).get(j)[1];
//                int weight = adj.get(i).get(j)[2];
//                Edge edge = new Edge(src, dest, weight);
//                edges.add(edge);
//            }
//        }

        List<Edge> edges = new ArrayList<>();

        for (List<int[]> row : adj) {
            for (int[] col : row) {
                int src = col[0];
                int dest = col[1];
                int weight = col[2];
                Edge edge = new Edge(src, dest, weight);
                edges.add(edge);
            }
        }

        Collections.sort(edges);
        int sum = 0;

        DisjointSet ds = new DisjointSet(V);
        List<int[]> newPaths = new ArrayList<>();

        for (Edge ed : edges) {

            int src = ed.src;
            int dest = ed.dest;
            int wt = ed.weight;

            if (ds.find(src) != ds.find(dest)) {
                sum += wt;
                ds.union(src, dest);

                int[] newPath = ds.getNewPath(src, dest);
                newPaths.add(new int[]{newPath[0], dest, wt});

            }
        }

        for (int[] col : newPaths) {
            int src = col[0];
            int dest = col[1];
            int weight = col[2];
            System.out.println("Src : " + src + " Dest : " + dest + " Weight : " + weight);
        }

        return sum;
    }
}