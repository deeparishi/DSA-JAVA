package com.deeparishi.javaapp.dsaconcepts.graph.bellmanford;

import com.deeparishi.javaapp.dsaconcepts.graph.utls.WeightedGraphNode;

import java.util.List;

public class BellmanFord {

    List<WeightedGraphNode> graphNodes;

    public BellmanFord(List<WeightedGraphNode> graphNodes) {
        this.graphNodes = graphNodes;
    }

    public void addWeightedEdge(int from, int to, int diatance) {
        WeightedGraphNode first = graphNodes.get(from);
        WeightedGraphNode second = graphNodes.get(to);
        first.neighbour.add(second);
        first.weightMap.put(second, diatance);
    }

    public void bellmanFordAlgo(WeightedGraphNode sourceNode) {
        sourceNode.distance = 0;
        for (int i = 0; i < graphNodes.size(); i++) {
            for (WeightedGraphNode currentNode : graphNodes) {
                for (WeightedGraphNode neighbour : currentNode.neighbour) {
                    if (neighbour.distance > currentNode.distance + currentNode.weightMap.get(neighbour)) {
                        neighbour.distance = currentNode.distance + currentNode.weightMap.get(neighbour);
                        neighbour.parent = currentNode;
                    }
                }
            }
        }

        System.out.println("Analyzing any Negative cycle is present....");

        for (WeightedGraphNode currNode : graphNodes) {
            for (WeightedGraphNode neighbour : currNode.neighbour) {
                if (neighbour.distance > currNode.distance + currNode.weightMap.get(neighbour)) {
                    System.out.println("Negative cycle found here..");
                    System.out.println("Vertex name: " + neighbour.name);
                    System.out.println("Old Cost: " + neighbour.distance);
                    int newDistance = currNode.distance + currNode.weightMap.get(neighbour);
                    System.out.println("new cost: " + newDistance);
                    return;
                }
            }
        }

        System.out.println("Negative cycle not found...");
        for (WeightedGraphNode nodeToPrint : graphNodes) {
            System.out.print("Weighted Graph Node: " + nodeToPrint + ", distance: " + nodeToPrint.distance + ", Path: ");
            pathToPrint(nodeToPrint);
            System.out.println();
        }
    }

    private void pathToPrint(WeightedGraphNode nodeToPrint) {
        if (nodeToPrint.parent != null)
            pathToPrint(nodeToPrint.parent);
        System.out.print(nodeToPrint + " ");
    }
}