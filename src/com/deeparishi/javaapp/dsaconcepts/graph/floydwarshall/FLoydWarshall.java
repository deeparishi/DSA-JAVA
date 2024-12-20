package com.deeparishi.javaapp.dsaconcepts.graph.floydwarshall;

import com.deeparishi.javaapp.dsaconcepts.graph.utls.WeightedGraphNode;

import java.util.ArrayList;
import java.util.List;

public class FLoydWarshall {

    public static void main(String[] args) {

        List<WeightedGraphNode> graphNodes = new ArrayList<>();
        graphNodes.add(new WeightedGraphNode("A", 0));
        graphNodes.add(new WeightedGraphNode("B", 1));
        graphNodes.add(new WeightedGraphNode("C", 2));
        graphNodes.add(new WeightedGraphNode("D", 3));

        FloydWarshallAlgo floydWarshall = new FloydWarshallAlgo(graphNodes);
        floydWarshall.addWeightedEdge(0, 3, 1);
        floydWarshall.addWeightedEdge(0, 1, 8);
        floydWarshall.addWeightedEdge(1, 2, 1);
        floydWarshall.addWeightedEdge(2, 0, 4);
        floydWarshall.addWeightedEdge(3, 1, 2);
        floydWarshall.addWeightedEdge(3, 2, 9);

        floydWarshall.floydWarshall();

    }

}
