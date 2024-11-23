package com.deeparishi.javaapp.dsaconcepts.graph.topologicalsort;

import com.deeparishi.javaapp.dsaconcepts.graph.utls.GraphNode;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<GraphNode> graphNodes = new ArrayList<>();

        graphNodes.add(new GraphNode("A", 0, new ArrayList<>()));
        graphNodes.add(new GraphNode("B", 1, new ArrayList<>()));
        graphNodes.add(new GraphNode("C", 2, new ArrayList<>()));
        graphNodes.add(new GraphNode("D", 3, new ArrayList<>()));
        graphNodes.add(new GraphNode("E", 4, new ArrayList<>()));
        graphNodes.add(new GraphNode("F", 5, new ArrayList<>()));
        graphNodes.add(new GraphNode("G", 6, new ArrayList<>()));
        graphNodes.add(new GraphNode("H", 7, new ArrayList<>()));

        TopologicalSort sort = new TopologicalSort(graphNodes);
        sort.directedEdge(0, 2);
        sort.directedEdge(2, 4);
        sort.directedEdge(4, 7);
        sort.directedEdge(4, 5);
        sort.directedEdge(5, 6);

        sort.topologicalSort();
        System.out.println();
    }

}
