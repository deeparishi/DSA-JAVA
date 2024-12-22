package com.deeparishi.javaapp.dsaconcepts.graph.minimumspantree.utls;

public class Edge implements Comparable<Edge> {

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public int src;

    public int dest;

    public int weight;

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }

}
