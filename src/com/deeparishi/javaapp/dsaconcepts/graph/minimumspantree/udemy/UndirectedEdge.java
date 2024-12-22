package com.deeparishi.javaapp.dsaconcepts.graph.minimumspantree.udemy;

public class UndirectedEdge {

    public UndirectedEdge(WeightedNode first, WeightedNode second, int weight) {
        this.first = first;
        this.second = second;
        this.weight = weight;
    }

    public WeightedNode first;

    public WeightedNode second;

    public int weight;
}
