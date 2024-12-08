package com.deeparishi.javaapp.dsaconcepts.graph.utls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraphNode implements Comparable<WeightedGraphNode> {

    public String name;

    public List<WeightedGraphNode> neighbour = new ArrayList<>();

    public Map<WeightedGraphNode, Integer> weightMap = new HashMap<>();

    public int index;

    public WeightedGraphNode parent;

    public int distance = Integer.MAX_VALUE;

    public boolean isVisited = false;

    public WeightedGraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }

    @Override
    public String toString() {
        return name;
    }


    @Override
    public int compareTo(WeightedGraphNode o) {
        return this.distance - o.distance;
    }

}