package com.deeparishi.javaapp.dsaconcepts.graph.dijikistra;

import com.deeparishi.javaapp.dsaconcepts.graph.utls.WeightedGraphNode;

import java.util.List;
import java.util.PriorityQueue;

public class Dijkistra {

    List<WeightedGraphNode> graphNodes;

    public Dijkistra(List<WeightedGraphNode> graphNodes) {
        this.graphNodes = graphNodes;
    }

    public void addWeightedEdge(int from, int to, int diatance) {
        WeightedGraphNode first = graphNodes.get(from);
        WeightedGraphNode second = graphNodes.get(to);
        first.neighbour.add(second);
        first.weightMap.put(second, diatance);
    }

    public void dijkistraAlgo(WeightedGraphNode node) {
        PriorityQueue<WeightedGraphNode> queue = new PriorityQueue<>();
        node.distance = 0;
        queue.addAll(graphNodes);

        while (!queue.isEmpty()) {
            WeightedGraphNode polled = queue.poll();

            for (WeightedGraphNode neighbour : polled.neighbour) {
                if (queue.contains(neighbour)) {
                    if (neighbour.distance > polled.distance + polled.weightMap.get(neighbour)) {
                        neighbour.distance = polled.distance + polled.weightMap.get(neighbour);
                        neighbour.parent = polled;
                        queue.remove(neighbour);
                        queue.add(neighbour);
                    }
                }
            }
        }

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