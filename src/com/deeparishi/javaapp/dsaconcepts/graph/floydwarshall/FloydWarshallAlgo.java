package com.deeparishi.javaapp.dsaconcepts.graph.floydwarshall;

import com.deeparishi.javaapp.dsaconcepts.graph.utls.WeightedGraphNode;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshallAlgo {

    List<WeightedGraphNode> graphNodes = new ArrayList<>();

    public FloydWarshallAlgo(List<WeightedGraphNode> graphNodes) {
        this.graphNodes = graphNodes;
    }

    public void addWeightedEdge(int from, int to, int diatance) {
        WeightedGraphNode first = graphNodes.get(from);
        WeightedGraphNode second = graphNodes.get(to);
        first.neighbour.add(second);
        first.weightMap.put(second, diatance);
    }

    public void floydWarshall(){

        int size = graphNodes.size();
        int[][] vertices = new int[size][size];

        for (int i = 0; i < size; i++) {
            WeightedGraphNode first = graphNodes.get(i);
            for (int j = 0; j < size; j++) {
                WeightedGraphNode second = graphNodes.get(j);
                if (i == j)
                    vertices[i][j] = 0;
                else if (first.weightMap.containsKey(second))
                    vertices[i][j] = first.weightMap.get(second);
                else
                    vertices[i][j] = Integer.MAX_VALUE / 10;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (vertices[i][k] + vertices[k][j] < vertices[i][j])
                        vertices[i][j] = vertices[i][k] + vertices[k][j];
                }
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.print("Printing Distance list for node " + graphNodes.get(i) + " : ");
            for (int j = 0; j < size; j++) {
                System.out.print(vertices[i][j] + " ");
            }
            System.out.println();
        }
    }
}
