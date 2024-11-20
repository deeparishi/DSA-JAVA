package com.deeparishi.javaapp.dsaconcepts.graph.basic;

import com.deeparishi.javaapp.dsaconcepts.graph.utls.GraphNode;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<GraphNode> graphNodes = new ArrayList<>();
        graphNodes.add(new GraphNode("A", 0));
        graphNodes.add(new GraphNode("B", 1));
        graphNodes.add(new GraphNode("C", 2));
        graphNodes.add(new GraphNode("D", 3));
        graphNodes.add(new GraphNode("E", 4));

        GraphUsingMatrix graph = new GraphUsingMatrix(graphNodes);
        graph.addConnection(0, 1);
        graph.addConnection(0, 2);
        graph.addConnection(0, 3);
        graph.addConnection(1, 0);
        graph.addConnection(1, 3);
        graph.addConnection(2, 1);
        graph.addConnection(2, 4);
        graph.addConnection(3, 1);
        graph.addConnection(3, 2);
        graph.addConnection(3, 4);
        graph.addConnection(4, 2);
        graph.addConnection(4, 3);

        graph.print();
        System.out.println();
        System.out.println();

        List<GraphNode> graphNodesList = new ArrayList<>();
        graphNodesList.add(new GraphNode("A", 0, new ArrayList<>()));
        graphNodesList.add(new GraphNode("B", 1, new ArrayList<>()));
        graphNodesList.add(new GraphNode("C", 2, new ArrayList<>()));
        graphNodesList.add(new GraphNode("D", 3, new ArrayList<>()));
        graphNodesList.add(new GraphNode("E", 4, new ArrayList<>()));

        GraphUsingList graphUsingList = getGraphUsingList(graphNodesList);

        System.out.println(graphUsingList.toString());
    }

    private static GraphUsingList getGraphUsingList(List<GraphNode> graphNodesList) {
        GraphUsingList graphUsingList = new GraphUsingList(graphNodesList);
        graphUsingList.addConnection(0, 1);
        graphUsingList.addConnection(0, 2);
        graphUsingList.addConnection(0, 3);
        graphUsingList.addConnection(1, 0);
        graphUsingList.addConnection(1, 3);
        graphUsingList.addConnection(2, 1);
        graphUsingList.addConnection(2, 4);
        graphUsingList.addConnection(3, 1);
        graphUsingList.addConnection(3, 2);
        graphUsingList.addConnection(3, 4);
        graphUsingList.addConnection(4, 2);
        graphUsingList.addConnection(4, 3);
        return graphUsingList;
    }
}
