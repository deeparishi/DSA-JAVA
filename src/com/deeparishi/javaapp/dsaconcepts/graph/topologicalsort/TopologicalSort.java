package com.deeparishi.javaapp.dsaconcepts.graph.topologicalsort;

import com.deeparishi.javaapp.dsaconcepts.graph.utls.GraphNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

    List<GraphNode> graphNodes;

    public TopologicalSort(List<GraphNode> graphNodes){
        this.graphNodes = graphNodes;
    }

    public void directedEdge(int a, int b) {

        GraphNode first = graphNodes.get(a);
        GraphNode second = graphNodes.get(b);
        first.neighbours.add(second);

    }

    private void topologicalSort(GraphNode node, Stack<GraphNode> stack) {
        node.isVisited = true;
        for (GraphNode neighbour : node.neighbours) {
            if (!neighbour.isVisited)
                topologicalSort(neighbour, stack);
        }

        stack.push(node);
    }

    public void topologicalSort() {

        Stack<GraphNode> stack = new Stack<>();

        for (GraphNode node : graphNodes) {
            if (!node.isVisited)
                topologicalSort(node, stack);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().name + " ");
        }
    }
}
