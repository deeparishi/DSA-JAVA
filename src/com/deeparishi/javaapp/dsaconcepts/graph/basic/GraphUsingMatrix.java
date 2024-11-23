package com.deeparishi.javaapp.dsaconcepts.graph.basic;

import com.deeparishi.javaapp.dsaconcepts.graph.utls.GraphNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GraphUsingMatrix {

    List<GraphNode> graphNodes;
    int[][] connections;

    public GraphUsingMatrix(List<GraphNode> graphNodes) {
        this.graphNodes = graphNodes;
        this.connections = new int[graphNodes.size()][graphNodes.size()];
    }

    public void addConnection(int a, int b) {
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

    public void bfs() {
        graphNodes.stream()
                .filter(node -> !node.isVisited)
                .forEach(this::bfs);
        resetVisited();
    }

    public void bfs(GraphNode graphNode) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(graphNode);

        while (!queue.isEmpty()) {
            GraphNode node = queue.removeFirst();
            node.isVisited = true;
            System.out.print(node.name + " ");

            List<GraphNode> neighbours = getNeighbours(node);
            for (GraphNode neighbour : neighbours) {
                if (!neighbour.isVisited) {
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    public void dfs() {
        graphNodes.stream()
                .filter(node -> !node.isVisited)
                .forEach(this::dfs);
        resetVisited();
    }

    private void dfs(GraphNode graphNode) {
        Stack<GraphNode> stack = new Stack<>();
        stack.push(graphNode);

        while (!stack.isEmpty()) {
            GraphNode node = stack.pop();
            node.isVisited = true;
            System.out.print(node.name + " ");
            List<GraphNode> neighbours = getNeighbours(node);
            neighbours.stream()
                    .filter(neighbour -> !neighbour.isVisited)
                    .forEach(neighbour -> {
                        neighbour.isVisited = true;
                        stack.push(neighbour);
                    });
        }
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
}