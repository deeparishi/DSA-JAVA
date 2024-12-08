package com.deeparishi.javaapp.dsaconcepts.graph.bellmanford;

import com.deeparishi.javaapp.dsaconcepts.graph.utls.WeightedGraphNode;

import java.util.ArrayList;
import java.util.List;

public class MainBellmanFord {

    public static void main(String[] args) {


        List<WeightedGraphNode> weightedGraphNodes = new ArrayList<>();
        weightedGraphNodes.add(new WeightedGraphNode("A", 0));
        weightedGraphNodes.add(new WeightedGraphNode("B", 1));
        weightedGraphNodes.add(new WeightedGraphNode("C", 2));
        weightedGraphNodes.add(new WeightedGraphNode("D", 3));
        weightedGraphNodes.add(new WeightedGraphNode("E", 4));
        weightedGraphNodes.add(new WeightedGraphNode("F", 5));
        weightedGraphNodes.add(new WeightedGraphNode("G", 6));


        // Below for only positive cycle
        BellmanFord dijkistra = new BellmanFord(weightedGraphNodes);

        dijkistra.addWeightedEdge(0, 1, 2);
        dijkistra.addWeightedEdge(0, 2, 5);
        dijkistra.addWeightedEdge(1, 2, 6);
        dijkistra.addWeightedEdge(1, 3, 1);
        dijkistra.addWeightedEdge(1, 4, 3);
        dijkistra.addWeightedEdge(2, 5, 8);
        dijkistra.addWeightedEdge(2, 4, 4);
        dijkistra.addWeightedEdge(4, 6, 9);
        dijkistra.addWeightedEdge(5, 6, 7);

        dijkistra.bellmanFordAlgo(weightedGraphNodes.getFirst());
        negativeCycle();

    }


    public static void negativeCycle(){

        List<WeightedGraphNode> weightedGraphNodes = new ArrayList<>();
        weightedGraphNodes.add(new WeightedGraphNode("A", 0));
        weightedGraphNodes.add(new WeightedGraphNode("B", 1));
        weightedGraphNodes.add(new WeightedGraphNode("C", 2));
        weightedGraphNodes.add(new WeightedGraphNode("D", 3));

        BellmanFord bellmanFord = new BellmanFord(weightedGraphNodes);

        System.out.println("Graph with negative cycle.....");
        // Add edges with weights, including a negative cycle
        bellmanFord.addWeightedEdge(0, 1, 1); // A → B (1)
        bellmanFord.addWeightedEdge(1, 2, 2); // B → C (2)
        bellmanFord.addWeightedEdge(2, 3, -4); // C → D (-4)
        bellmanFord.addWeightedEdge(3, 1, -1); // D → B (-1)

        // Run Bellman-Ford starting from node A
        bellmanFord.bellmanFordAlgo(weightedGraphNodes.getFirst());

    }

}
