package com.deeparishi.javaapp.dsaconcepts.graph.ssspp;

import com.deeparishi.javaapp.dsaconcepts.graph.utls.GraphNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathUsingMatrix {

    List<GraphNode> graphNodes;

    int[][] connections;

    public ShortestPathUsingMatrix(List<GraphNode> graphNodes){
        this.graphNodes = graphNodes;
        connections = new int[graphNodes.size()][graphNodes.size()];
    }

    public void addConnection(int x, int y){
        connections [x][y] = 1;
        connections [y][x] = 1;
    }

    private List<GraphNode> getNeighbours(GraphNode node) {
        List<GraphNode> neighbours = new ArrayList<>();
        for (int i = 0; i < connections.length; i++) {
            if (connections[node.index][i] == 1)
                neighbours.add(graphNodes.get(i));
        }
        return neighbours;
    }

    public void resetVisited() {
        graphNodes.forEach(graphNode -> graphNode.isVisited = false);
    }

    public void pathPrint(GraphNode node){
        if(node.parent != null)
            pathPrint(node.parent);

        System.out.print(node.name + " ");
    }

    public void BFS(GraphNode node) {

        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {

            GraphNode polled = queue.poll();
            polled.isVisited = true;

            for (GraphNode neighbour : getNeighbours(polled)) {
                if(!neighbour.isVisited) {
                    neighbour.isVisited = true;
                    neighbour.parent = polled;
                    queue.add(neighbour);
                }
            }

        }
    }
}
