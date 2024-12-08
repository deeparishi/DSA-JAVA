package com.deeparishi.javaapp.dsaconcepts.graph.utls;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    public String name;

    public int index;

    public List<GraphNode> neighbours;

    public boolean isVisited;

    public GraphNode parent;

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
