package com.deeparishi.javaapp.dsaconcepts.graph.basic;

import com.deeparishi.javaapp.dsaconcepts.graph.utls.GraphNode;

import java.util.ArrayList;
import java.util.List;

public class BasicGraph {

    public static void main(String[] args) {

//        usingMatrix();
        getGraphUsingList();

    }

    private static void usingMatrix() {

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
        System.out.println("Breadth First Search");
        graph.bfs();
        System.out.println();
        System.out.println("Depth First Search");
        graph.dfs();
        System.out.println();
    }

    private static void getGraphUsingList() {

        List<GraphNode> graphNodesList = new ArrayList<>();
        graphNodesList.add(new GraphNode("A", 0, new ArrayList<>()));
        graphNodesList.add(new GraphNode("B", 1, new ArrayList<>()));
        graphNodesList.add(new GraphNode("C", 2, new ArrayList<>()));
        graphNodesList.add(new GraphNode("D", 3, new ArrayList<>()));
        graphNodesList.add(new GraphNode("E", 4, new ArrayList<>()));

        GraphUsingList graphUsingList = new GraphUsingList(graphNodesList);

        graphUsingList.addConnection(0, 1);
        graphUsingList.addConnection(0, 2);
        graphUsingList.addConnection(0, 3);

        graphUsingList.addConnection(1, 0);
        graphUsingList.addConnection(1, 2);
        graphUsingList.addConnection(1, 3);

        graphUsingList.addConnection(2, 0);
        graphUsingList.addConnection(2, 1);
        graphUsingList.addConnection(2, 4);

        graphUsingList.addConnection(3, 0);
        graphUsingList.addConnection(3, 1);
        graphUsingList.addConnection(3, 4);

        graphUsingList.addConnection(4, 2);
        graphUsingList.addConnection(4, 3);


        System.out.println(graphUsingList.toString());
        System.out.println();
        System.out.println();

        System.out.println("Breadth First Search");
        graphUsingList.bfs();
        System.out.println();
        graphUsingList.resetVisited();


        System.out.println("Depth First Search");
        graphUsingList.dfs();
        System.out.println();
        graphUsingList.resetVisited();
    }
}
