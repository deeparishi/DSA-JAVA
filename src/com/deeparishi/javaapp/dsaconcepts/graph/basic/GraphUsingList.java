package com.deeparishi.javaapp.dsaconcepts.graph.basic;

import com.deeparishi.javaapp.dsaconcepts.graph.utls.GraphNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphUsingList {

    List<GraphNode> graphNodes;

    public GraphUsingList(List<GraphNode> graphNodes) {
        this.graphNodes = graphNodes;
    }

    public void addConnection(int a, int b) {
        GraphNode first = graphNodes.get(a);
        GraphNode second = graphNodes.get(b);
//        if (!first.neighbours.contains(second))
            first.neighbours.add(second);
//        if (!second.neighbours.contains(first))
            second.neighbours.add(first);
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        for (GraphNode graphNode : graphNodes) {
            s.append(graphNode.name).append(": ");
            for (int j = 0; j < graphNode.neighbours.size(); j++) {
                if (j == graphNode.neighbours.size() - 1) {
                    s.append((graphNode.neighbours.get(j).name));
                } else {
                    s.append(graphNode.neighbours.get(j).name).append(" -> ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void bfs(){
        graphNodes.stream()
                .filter(node -> !node.isVisited)
                .forEach(this::bfs);
    }

    public void bfs(GraphNode node){
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()){
            GraphNode polled = queue.poll();
            System.out.print(polled.name + " ");
            polled.isVisited = true;
            List<GraphNode> neighbours = getNeighbours(polled);

            for (GraphNode neighbour : neighbours){
                if(!neighbour.isVisited){
                    queue.add(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    void dfs(){
        graphNodes.stream()
                .filter(node ->  !node.isVisited)
                .forEach(this::dfs);
    }

    void dfs(GraphNode graphNode) {

        Stack<GraphNode> stack = new Stack<>();
        stack.push(graphNode);

        while (!stack.isEmpty()) {
            GraphNode node = stack.pop();
            node.isVisited = true;
            System.out.print(node.name + " ");
            List<GraphNode> neighbours = getNeighbours(node);
            for (GraphNode neighbour : neighbours) {
                if (!neighbour.isVisited) {
                    stack.push(neighbour);
                    neighbour.isVisited = true;
                }
            }
        }
    }

    public List<GraphNode> getNeighbours(GraphNode graphNode){
        return graphNode.neighbours;
    }

    public void resetVisited() {
        for (GraphNode node : graphNodes) {
            node.isVisited = false;
        }
    }
}
