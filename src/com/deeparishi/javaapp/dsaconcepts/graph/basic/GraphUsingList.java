package com.deeparishi.javaapp.dsaconcepts.graph.basic;

import com.deeparishi.javaapp.dsaconcepts.graph.utls.GraphNode;

import java.util.List;

public class GraphUsingList {

    List<GraphNode> graphNodes;

    public GraphUsingList(List<GraphNode> graphNodes){
        this.graphNodes = graphNodes;
    }

    public void addConnection(int a, int b){
        GraphNode x = graphNodes.get(a);
        GraphNode y = graphNodes.get(b);

        x.neighbours.add(y);
        y.neighbours.add(x);
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

}
