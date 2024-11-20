package com.deeparishi.javaapp.dsaconcepts.graph.basic;

import com.deeparishi.javaapp.dsaconcepts.graph.utls.GraphNode;

import java.util.ArrayList;
import java.util.List;

public class GraphUsingMatrix {

    List<GraphNode> graphNodes;
    int[][] connections;

    public GraphUsingMatrix(List<GraphNode> graphNodes){
        this.graphNodes = graphNodes;
        this.connections = new int[graphNodes.size()][graphNodes.size()];
    }

    public void addConnection(int a, int b){
        connections[a][b] = 1;
    }

    public void print() {

        System.out.print("  ");
        for (GraphNode node : graphNodes) {
            System.out.print(node.name + " ");
        }
        System.out.println();
        for (int i = 0; i < connections.length; i++) {
            System.out.print(graphNodes.get(i).name + " ");
            for (int j = 0; j < connections[i].length; j++) {
                System.out.print(connections[i][j] + " ");
            }
            System.out.println();
        }
    }

}
