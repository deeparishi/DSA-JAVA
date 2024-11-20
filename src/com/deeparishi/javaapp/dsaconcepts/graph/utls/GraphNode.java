package com.deeparishi.javaapp.dsaconcepts.graph.utls;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    public String name;

    int index;

    public List<GraphNode> neighbours;

    public GraphNode(String name, int index, List<GraphNode> neighbours) {
        this.name = name;
        this.index = index;
        this.neighbours = neighbours;
    }

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }

}
