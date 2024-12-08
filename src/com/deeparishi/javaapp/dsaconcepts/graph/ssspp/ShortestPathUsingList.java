package com.deeparishi.javaapp.dsaconcepts.graph.ssspp;

import com.deeparishi.javaapp.dsaconcepts.graph.utls.GraphNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathUsingList {

    List<GraphNode> graphNodes;

    public ShortestPathUsingList(List<GraphNode> graphNodes){
        this.graphNodes = graphNodes;
    }

    public void addConnection(int a, int b) {
        GraphNode first = graphNodes.get(a);
        GraphNode second = graphNodes.get(b);
        first.neighbours.add(second);
        second.neighbours.add(first);
    }

    public void BFS(GraphNode node) {

        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        node.isVisited = true;

        while (!queue.isEmpty()) {

            GraphNode polled = queue.poll();

            for (GraphNode neighbour : polled.neighbours) {
                if (!neighbour.isVisited) {
                    neighbour.parent = polled;
                    neighbour.isVisited = true;
                    queue.add(neighbour);
                }
            }
        }
    }

    public void printPath(GraphNode node) {
        if (node.parent != null) {
            printPath(node.parent);
        }
        System.out.print(node.name + " ");
    }



}
