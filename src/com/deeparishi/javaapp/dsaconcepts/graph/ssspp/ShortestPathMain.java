package com.deeparishi.javaapp.dsaconcepts.graph.ssspp;

import com.deeparishi.javaapp.dsaconcepts.graph.utls.GraphNode;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathMain {
    public static void main(String[] args) {

        List<GraphNode> graphNodes = new ArrayList<>();
        graphNodes.add(new GraphNode("A", 0, new ArrayList<>()));
        graphNodes.add(new GraphNode("B", 1, new ArrayList<>()));
        graphNodes.add(new GraphNode("C", 2, new ArrayList<>()));
        graphNodes.add(new GraphNode("D", 3, new ArrayList<>()));
        graphNodes.add(new GraphNode("E", 4, new ArrayList<>()));
        graphNodes.add(new GraphNode("F", 5, new ArrayList<>()));
        graphNodes.add(new GraphNode("G", 6, new ArrayList<>()));

        ShortestPathUsingMatrix graph = new ShortestPathUsingMatrix(graphNodes);
        graph.addConnection(0, 1);
        graph.addConnection(0, 2);
        graph.addConnection(1, 3);
        graph.addConnection(1, 6);
        graph.addConnection(2, 3);
        graph.addConnection(2, 4);
        graph.addConnection(3, 5);
        graph.addConnection(4, 5);
        graph.addConnection(5, 6);

        graph.BFS(graphNodes.getFirst());

        for (GraphNode node : graphNodes) {
            System.out.print("Path to " + node.name + ": ");
            graph.pathPrint(node);
            System.out.println();
        }

    }
}
